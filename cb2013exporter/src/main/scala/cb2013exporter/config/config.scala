package config

import cats.effect.{Blocker, ContextShift, IO, Resource}
import com.typesafe.config.ConfigFactory
import pureconfig._
import pureconfig.generic.auto._


case class DatabaseConfig(
    driver:         String,
    url:            String,
    username:       String,
    password:       String
)

case class ElasticsearchIndexConfig(
    name:           String,
    shards:         Int,
    replicas:       Int
)

case class ElasticsearchIndexesConfig(
    companies:      ElasticsearchIndexConfig
)

case class ElasticsearchConnectionConfig(
    schema:         String,
    host:           String,
    port:           Int,
)

case class ElasticsearchConfig(
    connection:     ElasticsearchConnectionConfig,
    indexes:        ElasticsearchIndexesConfig
)

case class Config(
    database:       DatabaseConfig,
    elasticsearch:  ElasticsearchConfig
)


object Config {

    /*
        *  TODO use blocker as here https://github.com/jaspervz/todo-http4s-doobie/blob/master/src/main/scala/config/package.scala
        *  TODO unpack Result here? Resource.liftF(IO(ConfigSource.default.load[Config])) : ConfigReader.Result
        * Resource.liftF(IO(ConfigSource.default.loadOrThrow[Config]))
        */

    def load(configFile: String = "application.conf")(implicit cs: ContextShift[IO]): Resource[IO, Config] = {
        Resource.liftF(IO(ConfigSource.default.loadOrThrow[Config]))
    }
}

