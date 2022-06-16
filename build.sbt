ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

ThisBuild / libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11"
ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"


//jacoco and codecov
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

//Excludes for Testing
jacocoExcludes := Seq(
  "src.main.scala.dud.aview*",
  "src.main.scala.dud.DrunterundDrueber"
)


// swing
libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"



// fx
// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R25"

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add dependency on JavaFX libraries, OS dependent
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map(m =>
  "org.openjfx" % s"javafx-$m" % "16" classifier osName
)


// Dependencie-Injection
libraryDependencies += "com.google.inject.extensions" % "guice-assistedinject" % "5.1.0"
libraryDependencies += ( "net.codingwell" %% "scala-guice" % "5.0.2" ).cross( CrossVersion.for3Use2_13 )