package org.qknow

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class WorkdCountTest extends AnyFunSpec with BeforeAndAfter {
  val master = "local" //sparkcontext的运行master
  var sc: SparkContext = _


  before {
    println("before")
    val conf = new SparkConf()
      .setAppName("test").setMaster(master)
    sc = new SparkContext(conf)
  }
  after {
    println("after")
    if (sc != null) {
      sc.stop()
    }
  }
  describe("WorkdCountTest") {
    describe("WordCount") {
      it("should ok") {
//        其中参数为rdd或者dataframe可以通过通过简单的手动构造即可
        val seq = Seq("the test test1", "the test", "the")
        val rdd = sc.parallelize(seq)
        val wordCounts = WordCount.count(rdd)
        wordCounts.map(p => {
          p._1 match {
            case "the" =>
              assert(p._2 == 3)
            case "test" =>
              assert(p._2 == 2)
            case "test1" =>
              assert(p._2 == 1)
            case _ =>
              None
          }
        }).foreach(_ => ())

      }
    }
  }

}