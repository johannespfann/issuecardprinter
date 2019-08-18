name := "IssueCardPrinter"
version := "0.1"
scalaVersion := "2.12.8"

lazy val global = project
  .in(file("."))
  .settings(settings)
  .aggregate(
    githubissueloader,
    loaderapi,
    printerapi,
    coreapi,
    core,
    filetemplateprinter
  )

lazy val core = project
  .settings(
    settings
  )
  .dependsOn(
    githubissueloader,
    filetemplateprinter
  )

lazy val coreapi = project
  .settings(
    settings
  )

lazy val printerapi = project
  .settings(
    settings
  )
  .dependsOn(
    coreapi
  )

lazy val loaderapi = project
  .settings(
    settings
  )
  .dependsOn(
    coreapi
  )

lazy val githubissueloader = project
  .settings(
    settings,
    libraryDependencies ++= githubissueloader_dependencies
  )
  .dependsOn(
    loaderapi,
    coreapi
  )


lazy val filetemplateprinter = project
  .settings(
    settings,
    libraryDependencies ++= commonDependencies
  )
  .dependsOn(
    printerapi
)

lazy val githubissueloader_dependencies = Seq(
  dependencies.rxjs,
  dependencies.github4s,
  dependencies.scalate,
  dependencies.scalatest  % "test",
  dependencies.scalacheck % "test"
)

lazy val commonDependencies = Seq(
  dependencies.typesafeConfig,
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