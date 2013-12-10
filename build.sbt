name := "stocks"

version := "1.0.0"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.4"

libraryDependencies += "org.joda" % "joda-convert" % "1.2"

libraryDependencies += "joda-time" % "joda-time" % "2.3"
