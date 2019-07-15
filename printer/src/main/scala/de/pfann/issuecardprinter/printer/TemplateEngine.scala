package de.pfann.issuecardprinter.printer

import org.fusesource.scalate._
import java.io._

object TemplateEngine {


  def main(args: Array[String]): Unit = {

    val engine = new TemplateEngine
    val output = engine.layout("C:\\Users\\jopf8\\projects\\IssueCardPrinter\\printer\\src\\main\\resources\\template.ssp", Map("name" -> ("Hiram", "Chirino"), "city" -> "Tampa"))

    val pw = new PrintWriter(new File("C:\\Users\\jopf8\\projects\\IssueCardPrinter\\printer\\src\\main\\resources\\output.html" ))
    pw.write(output)
    pw.close
    println(output)
  }

}
