import sbt._

object Dependencies {
  lazy val scalaTest =          "org.scalatest" %% "scalatest" % "3.1.1"
  lazy val fs2Core =            "co.fs2" %% "fs2-core" % "2.4.2"
  lazy val doobieCore =         "org.tpolecat" %% "doobie-core"      % "0.9.0"
  lazy val doobieHikari =       "org.tpolecat" %% "doobie-hikari"    % "0.9.0"          // HikariCP transactor.
  lazy val mysqlConnectorJava = "mysql" % "mysql-connector-java" % "8.0.21"
  lazy val newtype =            "io.estatico" %% "newtype" % "0.4.4"
  lazy val refined =            "eu.timepit" %% "refined" % "0.9.15"

  lazy val elastic4s =          "com.sksamuel.elastic4s" % "elastic4s-core_2.13" % "7.8.1"
  lazy val elastic4shttp =      "com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % "7.8.1"
  lazy val elastic4scats =      "com.sksamuel.elastic4s" %% "elastic4s-effect-cats"   % "7.8.1"
  lazy val elastic4scirce =     "com.sksamuel.elastic4s" %% "elastic4s-json-circe"    % "7.8.1"

  lazy val circeCore =          "io.circe" %% "circe-core" % "0.13.0"
  lazy val circeGeneric =       "io.circe" %% "circe-generic" % "0.13.0"
  lazy val circeParser =        "io.circe" %% "circe-parser" % "0.13.0"
  lazy val circeGenericExtras = "io.circe" %% "circe-generic-extras" % "0.13.0"

  lazy val pureconfig =         "com.github.pureconfig" %% "pureconfig" % "0.13.0"
}