import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "LoginApp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    //javaEbean,
    javaJpa,
    "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
//    "mysql" % "mysql-connector-java" % "5.1.19",
    "hsqldb" % "hsqldb" % "1.8.0.7",
    "org.mockito" % "mockito-all" % "1.8.4",
    "com.google.inject" % "guice" % "3.0",
    "com.google.inject.extensions" % "guice-servlet" % "3.0",
    "com.google.inject.extensions" % "guice-multibindings" % "3.0",
     "org.springframework" % "spring-asm" % "3.0.7.RELEASE",
    "org.springframework" % "spring-beans" % "3.0.7.RELEASE",
    "org.springframework" % "spring-context" % "3.0.7.RELEASE",
    "org.springframework" % "spring-core" % "3.0.7.RELEASE",
    "org.springframework" % "spring-expression" % "3.0.7.RELEASE",
    "org.springframework.data" % "spring-data-jpa" % "1.3.2.RELEASE",
    "commons-codec" % "commons-codec" % "1.4"

  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    //resolvers += "Local Play Repository" at "/home/swanand/softwares/play-2.1.2/repository/local"
    ebeanEnabled := false
  )

}
