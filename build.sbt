name := "IssueCardPrinter"
version := "0.1"
scalaVersion := "2.12.8"

lazy val global = project
  .in(file("."))
  .settings(settings)
  .aggregate(
    githubissueloader,
    api,
    core,
    printer,
    githubissueloader,
    configurationloader,
  )

lazy val core = project
  .settings(
    settings
  )
  .dependsOn(
    configurationloader,
    githubissueloader
  )

lazy val api = project
  .settings(
    settings
  )

lazy val githubissueloader = project
  .settings(
    settings,
    libraryDependencies ++= commonDependencies
  )
  .dependsOn(
    api,
    configurationloader
  )


lazy val printer = project
  .settings(
    settings,
    libraryDependencies ++= commonDependencies
  )

lazy val configurationloader = project
  .settings(
    settings,
    libraryDependencies ++= configurationloader_dependencies
  )
  .dependsOn(
    api
  )

lazy val configurationloader_dependencies = Seq(
  dependencies.typesafeConfig,
  dependencies.rxjs,
  dependencies.scalatest  % "test",
  dependencies.scalacheck % "test"
)

lazy val commonDependencies = Seq(
  dependencies.rxjs,
  dependencies.github4s,
  dependencies.scalate,
  dependencies.scalatest  % "test",
  dependencies.scalacheck % "test"
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

lazy val dependencies =
  new {
    val pureconfigV     = "0.8.0"
    val monocleV        = "1.4.0"
    val scalatestV      = "3.0.4"
    val scalacheckV     = "1.13.5"

    val typesafeConfig = "com.typesafe"               % "config"                   % "1.3.4"
    val scalatest      = "org.scalatest"              %% "scalatest"               % scalatestV
    val scalacheck     = "org.scalacheck"             %% "scalacheck"              % scalacheckV
    val rxjs           = "io.reactivex"               %% "rxscala"                 % "0.26.5"
    val github4s       = "com.47deg"                  %% "github4s"                % "0.20.1"
    val scalate        = "org.scalatra.scalate"       % "scalate-core_2.12"        % "1.9.4"
  }