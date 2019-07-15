package de.pfann.issuecardprinter.core

import de.pfann.issuecardprinter.configuration.GitHubConfigs
import de.pfann.issuecardprinter.githubissueloader.GitHubIssueLoader


class IssueCardPrinterEngine(gitHubConfigs: GitHubConfigs) {

  def process(): Unit = {

    println("Start printer")

    val loader = new GitHubIssueLoader(gitHubConfigs)


    loader.loadIssues() match {
      case Some(s) => println(s)
      case None => {
        println("war nix")
        return;
      }
    }

  }

}
