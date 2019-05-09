package de.pfann.issuecardprinter.printer

import de.pfann.issuecardprinter.common.Printer
import rx.lang.scala.Observable

import scala.concurrent.duration.DurationInt
import scala.language.{implicitConversions, postfixOps}

object Main {

  def main(args: Array[String]): Unit = {
    val printer = new Printer()
    printer.print();

    /*
    val client = new GitHubClient()
    client.setCredentials("johannespfann", "pw4sabrina4")

    val service = new RepositoryService()
    import scala.collection.JavaConversions._
    for (repo <- service.getRepositories("johannespfann")) {
      println(repo.getName + " Watchers: " + repo.getWatchers)
    }
*/

    val o = Observable.just(1, 2, 3)
    o.subscribe(
      n => println(n),
      e => e.printStackTrace(),
      () => println("done")
    )

    o.foreach(
      n => println(n),
      e => e.printStackTrace(),
      () => println("done")
    )

    val o2 = Observable.interval(200 millis).take(5)
    o2.subscribe(n => println("n = " + n))

    // need to wait here because otherwise JUnit kills the thread created by interval()

    //waitFor(o2)
    println("done")



  }

}
