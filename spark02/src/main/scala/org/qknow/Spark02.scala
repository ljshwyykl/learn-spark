package org.qknow

import org.apache.spark.sql.SparkSession


object Spark02 extends App {
  println("Spark02 main")


  val spark = SparkSession.builder.appName("Simple Application")
    .config("spark.master", "local[*]")
    // .master("local[*]")
    .getOrCreate()
  val df = spark.read
    .json("data/zipcodes.json")
    .cache()
  //  df.printSchema()
  df.show()

  //create properties object
  val prop = new java.util.Properties
  prop.setProperty("driver", "com.mysql.cj.jdbc.Driver")
  prop.setProperty("user", "root")
  prop.setProperty("password", "root")

  //jdbc mysql url - destination database is named "data"
  val url = "jdbc:mysql://localhost:3306/data"

  //destination database table
  val table = "sample_data_table"

  df.write.mode("append").jdbc(url, table, prop)

  // df.write.jdbc(url, table, prop)


}