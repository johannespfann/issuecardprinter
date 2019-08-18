package de.pfann.issuecardprinter.core

import de.pfann.issuecardprinter.githubissueloader.GitHubIssueLoader
import de.pfann.issuecardprinter.printer.{FileTemplatePrinter, PrinterConfig}


object IssueCardPrinter {

  def main(args: Array[String]): Unit = {
    val configuration = new Configuration("application.conf")
    val githubConfigs = configuration.load()
    val loader = new GitHubIssueLoader(githubConfigs)
    val printConfig = new PrinterConfig(
      "/home/johannes/projekte/issuecardprinter/filetemplateprinter/src/main/resources/template.ssp",
      "/home/johannes/projekte/issuecardprinter/filetemplateprinter/src/main/resources/output.html")
    val printer = new FileTemplatePrinter(printConfig)
    val issueCardPrinterEngine = new IssueCardPrinterEngine(loader,printer)

    issueCardPrinterEngine.process()

  }

}
