import play.sbt.PlayJava

name := """Attandance Managment"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  jdbc,
  javaEbean,
  "org.webjars" % "jquery" % "2.1.1",
  "org.webjars" % "bootstrap" % "3.3.1",
  "mysql" % "mysql-connector-java" % "5.1.18"
)

fork in run := true