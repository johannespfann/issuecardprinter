package de.pfann.issuecardprinter.printer

import de.pfann.issuecardprinter.coreapi.model.IssueItem

trait Printer {

  def printIssues(aContent: Seq[IssueItem]): Unit;

}
