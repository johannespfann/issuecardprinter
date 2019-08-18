package de.pfann.issuecardprinter.core

import de.pfann.issuecardprinter.githubissueloader.GitHubIssueLoader
import de.pfann.issuecardprinter.printer.{FileTemplatePrinter, PrinterConfig}


object IssueCardPrinter {

  def main(args: Array[String]): Unit = {
    val configuration = new Configuration("application.conf")

    val githubConfigs = configuration.loadGitHubConfig()
    val loader = new GitHubIssueLoader(githubConfigs)

    val printConfig = configuration.loadFilePrinterConfig()
    val printer = new FileTemplatePrinter(printConfig)

    val issueCardPrinterEngine = new IssueCardPrinterEngine(loader,printer)

    issueCardPrinterEngine.process()

  }

}
