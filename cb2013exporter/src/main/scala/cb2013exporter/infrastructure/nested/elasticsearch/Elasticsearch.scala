package infrastructure.nested.elasticsearch

import scala.concurrent.ExecutionContext
import cats.implicits._
import cats.effect.{Blocker, ContextShift, IO, Resource}
import com.sksamuel.elastic4s.http.JavaClient
import com.sksamuel.elastic4s.{ElasticClient, ElasticProperties, Executor, Functor, Response, RequestSuccess, RequestFailure}
import com.sksamuel.elastic4s.requests.indexes.{CreateIndexResponse, PutMappingResponse}
import com.sksamuel.elastic4s.requests.mappings.MappingDefinition
import com.sksamuel.elastic4s.ElasticDsl._

import config.{ElasticsearchConnectionConfig, ElasticsearchIndexConfig}


object Elasticsearch {

    def client(config: ElasticsearchConnectionConfig): Resource[IO, ElasticClient] = {
        Resource.make(
            IO(ElasticClient(JavaClient(ElasticProperties(s"${config.schema}://${config.host}:${config.port}"))))
        )(
            client => IO(client.close())
        )
    }

    def createOrUpdateMapping(config: ElasticsearchIndexConfig, client: ElasticClient, mapping: MappingDefinition)(implicit executor: Executor[IO], functor: Functor[IO]) =
        client.execute{
            putMapping(List(config.name)).fields(mapping.fields)
        }

    def initIndex(config: ElasticsearchIndexConfig, client: ElasticClient, mapping: MappingDefinition)(implicit executor: Executor[IO], functor: Functor[IO]): IO[Response[CreateIndexResponse]] =
        client.execute {
            createIndex(config.name)
                .shards(config.shards)
                .replicas(config.replicas)
                .mapping(mapping)
        }

    def initRepository(config: ElasticsearchIndexConfig, client: ElasticClient, mapping: MappingDefinition)(implicit executor: Executor[IO], functor: Functor[IO]): Resource[IO, EsDocumentRepository] =
        Resource.liftF(
            initIndex(config, client, mapping)
            .flatMap(_ match {
                case _: RequestSuccess[CreateIndexResponse]                                     => IO.pure(new EsDocumentRepository(config.name, client))
                case r: RequestFailure if r.error.`type` == "resource_already_exists_exception" => {
                    // in case index already exists, update mappings with new fields
                    createOrUpdateMapping(config, client, mapping).map(_ match {
                        case _: RequestSuccess[PutMappingResponse]  => new EsDocumentRepository(config.name, client)
                        case r: RequestFailure                      => r.result
                    })

                }
                case r: RequestFailure => r.result
            })
        )

}

