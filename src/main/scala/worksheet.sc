import dispatch._
import dispatch.Defaults._

object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	val svc = url("http://xml.wyborcza.biz/ArchivalProfileExportServlet.servlet?p5=WIG20&p6=2013-05-10&p7=2013-11-10&p8=1&p3=CSV&type=INDEX")
                                                  //> svc  : dispatch.Req = Req(<function1>)
    val string = Http(svc OK as.String)           //> SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
                                                  //| SLF4J: Defaulting to no-operation (NOP) logger implementation
                                                  //| SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further de
                                                  //| tails.
                                                  //| string  : dispatch.Future[String] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@5dd72248
    println(string)                               //> scala.concurrent.impl.Promise$DefaultPromise@5dd72248|
}