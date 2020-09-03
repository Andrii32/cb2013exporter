import cats.effect._
import doobie.util.ExecutionContexts
import fs2.Stream

import com.sksamuel.elastic4s.cats.effect.instances._

import config.Config
import application.NestedCompanyService
import infrastructure.nested.elasticsearch.{Elasticsearch}
import infrastructure.nested.elasticsearch.mapping.{CompanyMapping}
import infrastructure.normal.database.{Database, DbCbRepository}


object Cb2013Loader extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    val resources = for {
      config                <- Config.load()
      blocker               =  Blocker.liftExecutionContext(ExecutionContexts.synchronous)
      transactor            <- Database.transactor(config.database, blocker)
      dbRepository          =  new DbCbRepository(transactor)
      nestedCompanyService  =  new NestedCompanyService(dbRepository)
      esClient              <- Elasticsearch.client(config.elasticsearch.connection)
      esCompaniesRepository <- Elasticsearch.initRepository(config.elasticsearch.indexes.companies, esClient, CompanyMapping.mapping)
    } yield (nestedCompanyService, esCompaniesRepository)

    resources.use{
      case (nestedCompanyService, esCompaniesRepository) => nestedCompanyService
          .streamCompanyObjectsIds
          .evalMap(id => nestedCompanyService.getNestedCompany(id))
          .take(10)
          .chunkN(5) // todo take from configs
          .evalMapChunk(companies => esCompaniesRepository.save(companies.toVector))
          .evalTap(v => IO(println(v)))
        .compile
        .drain
    }
  }.as(ExitCode.Success)

}
