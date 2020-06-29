name := "learn-scala"

version := "0.1"

scalaVersion := "2.12.7"
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")

lazy val root = (project in file("."))
  .settings(
    name := "fsis",
    libraryDependencies ++= Seq(
      simulacrum,
      scalaCheck % Test
    )
  )