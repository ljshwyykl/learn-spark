package org.qknow

import org.scalatest.PrivateMethodTester
import org.scalatest.funspec.AnyFunSpec

class Spark02Test extends AnyFunSpec with PrivateMethodTester {
  describe("Spark02Test") {
    describe("doSth") {
      it("should ok") {
        val spark02 = new Spark02()
        val doSth = PrivateMethod[String](Symbol("doSth"))
        val str = spark02 invokePrivate doSth("string")
        assert(str == "doSth")

      }
    }
  }
}
