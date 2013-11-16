import java.util.concurrent.ExecutorService
import scala.concurrent.Await
import scala.concurrent.CanAwait
import scala.concurrent.duration.Duration
import dispatch._
import dispatch.Defaults._
import java.util.concurrent.Executors

object Main {

  val executorService: ExecutorService = Executors.newFixedThreadPool(5)

  def main(args: Array[String]) {

    val stocks = List(
      "ACP", "LWB", "BRE", "BZW", "EUR", "GTC", 
      "BHW", "JSW", "KER", "KGH", "LTS", "PEO",
      "PGE", "PGN", "PKN", "PKO", "PZU", "SNS", 
      "TPE", "TPS")

    val requests = 
      for (stock <- stocks)
        yield createRequest(stock)
    
    for (elem <- requests)
      for (v <- elem)
        println("done")
  }

  private def createRequest (stock: String): dispatch.Future[String] = {
    Http(
      url("http://xml.wyborcza.biz/ArchivalProfileExportServlet.servlet")
        .addQueryParameter("p5", stock)
        .addQueryParameter("p6", "2010-01-01")
        .addQueryParameter("p7", "2013-11-16")
        .addQueryParameter("p8", "1")
        .addQueryParameter("p3", "TXT")
        .addQueryParameter("type", "SHARE")
        OK as.String)
  }

}