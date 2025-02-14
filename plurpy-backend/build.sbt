ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "plurpy-backend",
    idePackagePrefix := Some("org.tomasmo.plurpy"),

    run / fork := true,

    Compile / PB.targets := Seq(
      scalapb.gen(grpc = true) -> (Compile / sourceManaged).value,
      scalapb.zio_grpc.ZioCodeGenerator -> (Compile / sourceManaged).value
    ),

    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-simple" % "2.0.5",
      "dev.zio" %% "zio-logging" % "2.1.5",
      "dev.zio" %% "zio-logging-slf4j" % "2.1.5",

      "io.grpc" % "grpc-netty" % "1.51.0",

      "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
      "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",

      "io.getquill" %% "quill-jdbc-zio" % "4.6.0",
      "org.postgresql" % "postgresql" % "42.2.8",

      "com.github.jwt-scala" %% "jwt-zio-json" % "9.1.2",

      "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.1",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.14.1",

      "dev.zio" %% "zio-config" % "3.0.6",
      "dev.zio" %% "zio-config-typesafe" % "3.0.6",
      "dev.zio" %% "zio-config-magnolia" % "3.0.6",
    )
  )
