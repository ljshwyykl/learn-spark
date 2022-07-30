package org.qknow

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Stream02 {
  def main(args: Array[String]): Unit = {
    // 在本地启动名为SimpleDemo的SparkStreaming应用
    // 该应用拥有两个线程，其批处理时间间隔为1s
    // 创建SparkConf
    val conf = new SparkConf().setMaster("local[*]").setAppName("SimpleDemo")
    // 从SparkConf创建StreamingContext并指定1秒钟的批处理大小
    val ssc = new StreamingContext(conf, Seconds(1))
    // 创建ReceiverInputDStream，该InputDStream的Receiver监听本地机器的7777端口
    val lines = ssc.socketTextStream("localhost", 7777) // 类型是ReceiverInputDStream
    // 从DStream中筛选出包含字符串"error"的行，构造出了
    // lines -> errorLines -> .print()这样一个DStreamGraph
    val errorLines = lines.filter(_.contains("error"))
    // 打印出含有"error"的行
    errorLines.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
