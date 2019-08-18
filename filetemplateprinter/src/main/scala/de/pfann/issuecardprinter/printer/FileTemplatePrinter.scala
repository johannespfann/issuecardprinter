package de.pfann.issuecardprinter.printer

import org.fusesource.scalate.TemplateEngine
import java.io._

import de.pfann.issuecardprinter.coreapi.model.IssueItem

class FileTemplatePrinter(val printerConfig: PrinterConfig) extends Printer {

  def printIssues(aContent: Seq[IssueItem]): Unit = {
    val engine = new TemplateEngine
    val output = engine.layout(printerConfig.getPathToTemplate(),
      Map(
        "issues_title" -> "Issues",
        "issues" -> aContent))
    val pw = new PrintWriter(new File(printerConfig.getOutputPath() ))
    pw.write(output)
    pw.close()
  }


}
