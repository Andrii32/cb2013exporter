import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:_",
  "-unchecked",
  // "-Wunused:_",
  "-Xfatal-warnings",
  "-Ymacro-annotations"
)

lazy val root = (project in file("."))
  .settings(
    name := "scala-mysql2es",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += fs2Core,
    libraryDependencies += doobieCore,
    libraryDependencies += doobieHikari,
    libraryDependencies += mysqlConnectorJava,
    libraryDependencies += newtype,
    libraryDependencies += refined,
    libraryDependencies += elastic4s,
    libraryDependencies += elastic4scats,
    libraryDependencies += elastic4shttp,
    libraryDependencies += elastic4scirce,
    libraryDependencies += circeCore,
    libraryDependencies += circeGeneric,
    libraryDependencies += circeParser,
    libraryDependencies += circeGenericExtras,
    libraryDependencies += pureconfig
  )


// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
// https://mvnrepository.com/artifact/org.scalamacros/paradise

