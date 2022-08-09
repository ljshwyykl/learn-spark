
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.12.14"


val scalaTest = "org.scalatest" %% "scalatest" % "3.2.7"

val sparkCore = "org.apache.spark" %% "spark-core" % "3.3.0"
val sparkSql = "org.apache.spark" %% "spark-sql" % "3.3.0"
val sparkStreaming = "org.apache.spark" %% "spark-streaming" % "3.3.0"


lazy val spark01 = (project in file("spark01"))
  .settings(
    name := "spark01",
    libraryDependencies ++= Seq(sparkCore, sparkSql),
    libraryDependencies += scalaTest % Test,
  )


lazy val log = (project in file("log4j"))
  .settings(
    name := "log4j",
    libraryDependencies ++= Seq(
      "org.apache.logging.log4j" %% "log4j-api-scala" % "12.0",
      "org.apache.logging.log4j" % "log4j-api" % "2.17.2",
      "org.apache.logging.log4j" % "log4j-core" % "2.17.2" % Runtime
    ),
    libraryDependencies += scalaTest % Test,
  )


lazy val spark02 = (project in file("spark02"))
  .settings(
    name := "spark02",
    libraryDependencies ++= Seq(sparkCore, sparkSql,sparkStreaming),
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.29",

    libraryDependencies += scalaTest % Test,
  )

lazy val bitmap = (project in file("bitmap"))
  .settings(
    name := "bitmap",
    // https://mvnrepository.com/artifact/org.roaringbitmap/RoaringBitmap
    libraryDependencies += "org.roaringbitmap" % "RoaringBitmap" % "0.9.30",
    libraryDependencies += scalaTest % Test,
  )