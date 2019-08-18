package de.pfann.issuecardprinter.issueloader.issueloader

import de.pfann.issuecardprinter.coreapi.model.IssueItem

trait IssueLoader {

  def loadIssue(issueId: String): Option[IssueItem]
  def loadIssues(): Option[Seq[IssueItem]]

}
