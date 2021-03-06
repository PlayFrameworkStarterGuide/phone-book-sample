import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play-starter-scala"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "com.typesafe.slick" %% "slick" % "1.0.0"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
