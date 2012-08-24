import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "todolist"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.squeryl" %% "squeryl" % "0.9.5-2",
    "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
    "org.myyk" %% "commonA" % "1.0-SNAPSHOT",
    "org.myyk" %% "commonB" % "1.0-SNAPSHOT"
    )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
  )

}
