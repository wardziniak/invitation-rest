name := """inviation-rest"""

scalaVersion := "2.11.6"

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

play.PlayImport.PlayKeys.playDefaultPort := 8080

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies += "com.evojam" % "play-mongodb-driver_2.11" % "0.3.1"