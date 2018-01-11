lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "little-scala-functions",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
  )
