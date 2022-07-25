package org.qknow

import org.apache.spark.sql.SparkSession

object Spark03 {
  def main(args: Array[String]): Unit = {
    println("Spark03 main")

    val spark = SparkSession.builder.appName("Simple Application")
      .config("spark.master", "local[*]")
      // .master("local[*]")
      .getOrCreate()
    val df = spark.read
      .json("/Users/wei/Desktop/project/scala/learn-spark/data/zipcodes.json")
      .cache()
    df.printSchema()
    df.show()

    df.select("City").show()


    df.createOrReplaceTempView("zipcodes")

    val sqlDF = spark.sql("SELECT * FROM zipcodes")
    sqlDF.show()
  }
}
