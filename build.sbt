import Dependencies._
//resolvers += "spray repo" at "http://repo.spray.io"
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "org.scala-lang.modules" %% "scala-xml" % "1.1.0",
       // "cc.spray.json" %% "spray-json" % "1.0.1",
       "io.spray" %% "spray-json" % "1.3.4"
    )

)
