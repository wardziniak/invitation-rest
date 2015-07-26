name := """inviation-rest"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

play.PlayImport.PlayKeys.playDefaultPort := 8080