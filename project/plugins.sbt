// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.2")

//Add Library dependency for Spring so that its classes are loaded

//The Local Repository
resolvers += "Local Play Repository" at "/home/swanand/softwares/play-2.1.2/repository/local"