ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

ThisBuild / libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11"
ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"



lazy val root = (project in file("."))
  .settings(
    name := "dud"
  )

jacocoReportSettings := JacocoReportSettings(
  "Jacoco Coverage Report",
  None,
  JacocoThresholds(),
  Seq(JacocoReportFormats.ScalaHTML, JacocoReportFormats.XML), // note XML formatter
  "utf-8")
