package de.pfann.issuecardprinter.core

import de.pfann.issuecardprinter.configuration.Configuration


object IssueCardPrinter {

  def main(args: Array[String]): Unit = {
    val configuration = new Configuration("application.conf")
    val githubConfigs = configuration.load()


    val issueCardPrinterEngine = new IssueCardPrinterEngine(githubConfigs)

    issueCardPrinterEngine.process()

  }

}
