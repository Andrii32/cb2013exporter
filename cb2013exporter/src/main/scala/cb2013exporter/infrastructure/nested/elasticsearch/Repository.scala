package infrastructure.nested.elasticsearch

import scala.concurrent.ExecutionContext
import cats.implicits._
import cats.effect.{Blocker, ContextShift, IO, Resource}
import io.circe.syntax._
import com.sksamuel.elastic4s.http.JavaClient
import com.sksamuel.elastic4s.{ElasticClient, ElasticProperties, Executor, Functor, Response, ElasticError}
import com.sksamuel.elastic4s.requests.bulk.BulkResponse
import com.sksamuel.elastic4s.requests.indexes.IndexResponse
import com.sksamuel.elastic4s.ElasticDsl._

import domain.nested.models.{NestedCompany}
import domain.nested.DocumentRepository
import application.encoders.NestedEncodersDecoders.{nestedCompanyDecoder, nestedCompanyEncoder}
import config.{ElasticsearchConnectionConfig, ElasticsearchIndexConfig}


class EsDocumentRepository(
    name:   String,
    client: ElasticClient
    )(
        implicit executor: Executor[IO], functor: Functor[IO]
    ) extends DocumentRepository[IO, ElasticError, IndexResponse, BulkResponse]{

    def save(doc: NestedCompany): IO[Either[ElasticError, IndexResponse]] = {
        client.execute {
            indexInto(name).doc(doc.asJson.noSpaces)
        }.map(_.toEither)
    }

    def save(docs: Seq[NestedCompany]): IO[Either[ElasticError, BulkResponse]] =
        client.execute {
            bulk(
                docs.map(_.asJson.noSpaces).map(x => indexInto(name).doc(x))
            )
        }.map(_.toEither)

}

