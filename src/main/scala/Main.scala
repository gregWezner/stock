import java.util.concurrent.ExecutorService
import scala.concurrent.Await
import scala.concurrent.CanAwait
import scala.concurrent.duration.Duration
import dispatch._
import dispatch.Defaults._
import java.util.concurrent.Executors
import org.joda.time.DateTime
import org.joda.convert.FromString
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.DateTimeFormatterBuilder

object Main {

  val executorService: ExecutorService = Executors.newFixedThreadPool(5)

  def main(args: Array[String]) {

    val stocks = List(
      "ACP", "LWB", "BRE", "BZW", "EUR", "GTC", 
      "BHW", "JSW", "KER", "KGH", "LTS", "PEO",
      "PGE", "PGN", "PKN", "PKO", "PZU", "SNS", 
      "TPE", "TPS")

      
      for (stock <- stocks)
    	  for (str <- result(stock)){
    		  println(stock) 
    		  println(str)
    	  }
  }
  
  def result(str: String) = {
    for(req <-createRequest(str))
      yield extract(req)
  }
  
  def extract(str: String): IndexedSeq[Tuple3[org.joda.time.DateTime, String, String]] = {
    val splitted = str.split("\n")
    val ret =
    for (i <- 1 to splitted.size-1)
    	yield (DateTime.parse(splitted(i).split(" ")(6)), splitted(i).split(" ")(0), splitted(i).split(" ")(3))
    ret
  }
  
  private def createRequest (stock: String): dispatch.Future[String] = {
    Http(
      url("http://xml.wyborcza.biz/ArchivalProfileExportServlet.servlet")
        .addQueryParameter("p5", stock)
        .addQueryParameter("p6", "2010-01-01")
//        .addQueryParameter("p7", "2013-11-16")
        .addQueryParameter("p8", "1")
        .addQueryParameter("p3", "TXT")
        .addQueryParameter("type", "SHARE")
        OK as.String)
  }

}