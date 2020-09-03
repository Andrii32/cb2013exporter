package infrastructure.normal.database

import scala.concurrent.ExecutionContext
import cats.effect.{Blocker, ContextShift, IO, Resource}
import doobie.{Transactor}

import config.DatabaseConfig


object Database {

    // TODO use hikari https://github.com/jaspervz/todo-http4s-doobie/blob/master/src/main/scala/db/Database.scala
    def transactor(config: DatabaseConfig, blocker: Blocker)(implicit contextShift: ContextShift[IO]): Resource[IO, Transactor[IO]] = {
        Resource.liftF(IO(
            Transactor.fromDriverManager[IO](
                config.driver,
                config.url,
                config.username,
                config.password,
                blocker
            )
        ))
    }
}

