// import Dependencies._

lazy val commonSettings = List(
  organization := "com.snapcardster",
  scalaVersion := "2.12.7",
  version := "0.1"
)

lazy val root = (project in file(".")).
  settings(
    //  assemblySettings : _*,
    inThisBuild(commonSettings),
    mainClass in assembly := Some("karstenbot.Program"),
    assemblyJarName in assembly := "karstenbot.jar",
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs@_*) => MergeStrategy.discard
      case x => MergeStrategy.first
    },
    name := "KarstenBot"
  )


// Core with minimal dependencies, enough to spawn your first bot.
libraryDependencies += "com.bot4s" %% "telegram-core" % "4.0.0-RC2"

// Extra goodies: Webhooks, support for games, bindings for actors.
libraryDependencies += "com.bot4s" %% "telegram-akka" % "4.0.0-RC2"