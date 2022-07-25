package org.qknow

import org.apache.logging.log4j.scala.Logging

object Log01 extends App with Logging {
  // println("sss")
  val a = "s"
  println(s"ssss ${a}")
  logger.info("Doing stuff")
}
