name := "IssueCardPrinter"
version := "0.1"
scalaVersion := "2.12.8"

lazy val global = project
  .in(file("."))
  .settings(settings)
  .aggregate(
    common,
    printer
  )


lazy val common = project
  .settings(
    settings,
    libraryDependencies ++= commonDependencies
  )


lazy val printer = project
  .settings(
    settings,
    libraryDependencies ++= commonDependencies
  )
  .dependsOn(
    common
  )

lazy val dependencies =
  new {
    val typesafeConfigV = "1.3.1"
    val pureconfigV     = "0.8.0"
    val monocleV        = "1.4.0"
    val akkaV           = "2.5.6"
    val scalatestV      = "3.0.4"
    val scalacheckV     = "1.13.5"

    val typesafeConfig = "com.typesafe"               % "config"                   % typesafeConfigV
    val akka           = "com.typesafe.akka"          %% "akka-stream"             % akkaV
    val monocleCore    = "com.github.julien-truffaut" %% "monocle-core"            % monocleV
    val monocleMacro   = "com.github.julien-truffaut" %% "monocle-macro"           % monocleV
    val pureconfig     = "com.github.pureconfig"      %% "pureconfig"              % pureconfigV
    val scalatest      = "org.scalatest"              %% "scalatest"               % scalatestV
    val scalacheck     = "org.scalacheck"             %% "scalacheck"              % scalacheckV
    val rxjs           = "io.reactivex"               %% "rxscala"                 % "0.26.5"
    val github         = "org.eclipse.mylyn.github" % "org.eclipse.egit.github.core" % "2.1.5"
  }

lazy val commonDependencies = Seq(
  dependencies.typesafeConfig,
  dependencies.akka,
  dependencies.scalatest  % "test",
  dependencies.scalacheck % "test",
  dependencies.rxjs,
  dependencies.github
)

lazy val settings = Seq(
  scalacOptions ++=  Seq(
    "-unchecked",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-deprecation",
    "-encoding",
    "utf8"
  ),
  resolvers ++= Seq(
    "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)