name := "film-database-java"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean).settings {
  libraryDependencies ++= Seq(
    jdbc,
    "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
    "mysql" % "mysql-connector-java" % "5.1.36",
    // https://adrianhurt.github.io/play-bootstrap/
    "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3"
  )
}
