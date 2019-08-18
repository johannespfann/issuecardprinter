package de.pfann.issuecardprinter.core

import de.pfann.issuecardprinter.configuration.GitHubConfig
import de.pfann.issuecardprinter.githubissueloader.GitHubIssueLoader
import de.pfann.issuecardprinter.issueloader.model.IssueItem


class IssueCardPrinterEngine(gitHubConfigs: GitHubConfig) {

  def process(): Unit = {
      println("Start printer")
      val loader = new GitHubIssueLoader(gitHubConfigs)

      val issues = loader.loadIssues().get


    }

}


