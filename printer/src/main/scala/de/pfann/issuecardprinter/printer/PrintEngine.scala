package de.pfann.issuecardprinter.printer

import org.fusesource.scalate.TemplateEngine
import java.io._

import de.pfann.issuecardprinter.issueloader.model.IssueItem

class PrintEngine(val printerConfig: PrinterConfig) {

  def printIssue(aContent: IssueItem): Unit = {
    val engine = new TemplateEngine
    val output = engine.layout(printerConfig.getPathToTemplate(),
      Map(
        "issue_id" -> aContent.id,
        "issue_title" -> aContent.titel,
        "issue_description" -> aContent.description,
        "issue_assigned" -> aContent.assigned,
        "issue_priority" -> aContent.priority))

    val pw = new PrintWriter(new File(printerConfig.getOutputPath() ))
    pw.write(output)
    pw.close()
    println(output)
  }


}
