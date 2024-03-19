organization := "macaja"
name:= "robot-explorer"

ThisBuild / turbo := true

lazy val commonSettings = Seq(
    scalaVersion := "2.13.12",
    name := "robot-explorer",
    libraryDependencies ++= Dependencies.common,
    libraryDependencies ++= Dependencies.test,
    coverageMinimum := 80,
    coverageFailOnMinimum := true,
    coverageHighlighting := true,
    ThisBuild / scalafmtOnCompile := true,
    Compile / run / fork := true,
    Compile / compile / wartremoverErrors ++= CustomWarts.all,
    Compile / scalacOptions --= Seq("-Xlint:nullary-override"),
)

lazy val root = (project in file("."))
    .settings(name := "root")
    .settings(commonSettings)
    .enablePlugins(ScoverageSbtPlugin)

addCommandAlias("coverageAgg", ";clean;update;compile;scalafmtCheck;test:scalafmtCheck;coverage;test;it:test;coverageAggregate")