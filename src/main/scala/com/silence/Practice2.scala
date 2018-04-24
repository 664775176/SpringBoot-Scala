import java.io.{File, FileNotFoundException}
import java.net.URL
import java.text.SimpleDateFormat

import scala.io.Source

object Practice2 {
  def main(args: Array[String]): Unit = {
    val path =  "C:\\Users\\zhch\\Downloads\\detail-productdb-service.2017-11-29.log\\detail-productdb-service.2017-11-29.log"
    val file = new File(path)

    def readFile(item: File): Unit = {
        val requestList = Source.fromFile(item).getLines().filter(_.contains("trans-pool-1-thread-"))
          .filter(_.contains("request header")).toList
        val responseList = Source.fromFile(item).getLines().filter(_.contains("trans-pool-1-thread-"))
          .filter(_.contains("response header")).toList
        val fm = new SimpleDateFormat("dd-MM HH:mm:ss SSS")
        val req = requestList.map(x=>{
          val f = x.split(" ")
          val time = fm.parse(f(0) + " " + f(1) + " " + f(2)).getTime  // 时间
          val thread = f(3) // 线程
          (time,thread)})

        val res = responseList.map(x=>{
          val f = x.split(" ")
          val time = fm.parse(f(0) + " " + f(1) + " " + f(2)).getTime  // 时间
          val thread = f(3) // 线程
          (time,thread)})
        val zip = (res zip req).map(p => (p._1._1 - p._2._1, p._2._2))
        val size = zip.groupBy(_._2).map(t=>(t._1,t._2.size))
        for(ele <- size) {
          println("线程：" + ele._1 + " 调用" + ele._2 + "次")
        }
        val sum = zip.groupBy(_._2).map(x => x._1 -> x._2.map(_._1).sum / x._2.size).toList
        val sorted = sum.sortBy{case(thread, time) => time}
        for(ele <- sorted) {
          println("线程：" +  ele._1 + "平均时长：" +ele._2 + "毫秒" )
        }
      println("top95平均时长:" + sorted(94))
      println("top95平均时长:" + sorted(98))
    }
    readFile(file)
  }
}