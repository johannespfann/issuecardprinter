package de.pfann.issuecardprinter.core

import de.pfann.issuecardprinter.issueloader.issueloader.IssueLoader
import de.pfann.issuecardprinter.printer.FileTemplatePrinter


class IssueCardPrinterEngine(loader: IssueLoader,printer: FileTemplatePrinter) {

  def process(): Unit = {
      println("Start printer")
      val issues = loader.loadIssues().get
      println("print " + issues.size + " issues ...")
      printer.printIssues(issues)
      println("printer succeeded")
    }

}


