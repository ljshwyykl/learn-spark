package org.qknow

import org.roaringbitmap.RoaringBitmap


object BitMapTest {
  def main(args: Array[String]): Unit = {
    println("BitMapTest")

    val rr2 = new RoaringBitmap;
    rr2.add(4000);
    rr2.add(5000);

    val result = rr2.contains(4000)

    println(result)
  }
}