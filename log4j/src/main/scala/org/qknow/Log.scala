package org.qknow

import org.apache.logging.log4j.scala.Logging
import org.apache.logging.log4j.Level

object Log extends App with Logging {
  def doStuff(): Unit = {
    logger.info("Doing stuff")
  }
  def doStuffWithLevel(level: Level): Unit = {
    logger(level, "Doing stuff with arbitrary level")
  }

  doStuff()
//  def doStuffWithUser(user: User): Unit = {
//    logger.info(s"Doing stuff with ${user.getName}.")
//  }
}