organization := "macaja"
name:= "robot-explorer"

ThisBuild / turbo := true

lazy val commonSettings = Seq(
    scalaVersion := "2.13.12",
    Test / fork := true,
    name := "robot-explorer",
    libraryDependencies ++= Dependencies.common,
    coverageMinimum := 98,
    coverageFailOnMinimum := true,
    coverageHighlighting := true,
    ThisBuild / scalafmtOnCompile := true,
    Compile / run / fork := true,
    Compile / compile / wartremoverErrors ++= CustomWarts.all,
    Compile / scalacOptions --= Seq("-Xlint:nullary-override"),
)

lazy val core = project
    .settings(
        commonSettings,
        libraryDependencies ++= Dependencies.test,
        name += "-core",
    ).enablePlugins(ScoverageSbtPlugin)

    lazy val root = (project in file("."))
    .aggregate(core)
    .settings(name := "root")
    .settings(commonSettings)

    addCommandAlias("coverageAgg", ";clean;update;compile;scalafmtCheck;test:scalafmtCheck;coverage;test;it:test;coverageAggregate")