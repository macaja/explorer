import sbt._

object Versions {
    lazy val scalaTest = "3.2.18"
}

object Dependencies {
    lazy val common: Seq[ModuleID] = Seq()

    lazy val test: Seq[ModuleID] = Seq(
        "org.scalatest" %% "scalatest"                    % Versions.scalaTest  % s"it,$Test",
        "org.scalatestplus" %% "scalatestplus-scalacheck" % "3.1.0.0-RC2"       % s"it,$Test",
    )
}