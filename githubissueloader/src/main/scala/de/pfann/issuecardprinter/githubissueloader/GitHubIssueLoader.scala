package de.pfann.issuecardprinter.githubissueloader

import de.pfann.issuecardprinter.configuration.GitHubConfigs
import de.pfann.issuecardprinter.issueloader.issueloader.IssueLoader
import de.pfann.issuecardprinter.issueloader.model.IssueItem
import github4s.Github
import github4s.Github._
import github4s.jvm.Implicits._
import scalaj.http.HttpResponse

class GitHubIssueLoader(gitHubConfigs: GitHubConfigs) extends IssueLoader{


  override def loadIssue(issueId: String): Option[IssueItem] = {

    val issueItem = IssueItem(
      "1j2nl312k3nk12",
      "Neuer Issue",
      "5",
      "Es ist was zu tun",
      "Johannes")

    Option(issueItem)
  }

  override def loadIssues(): Option[Seq[IssueItem]] = {

    val username: String = gitHubConfigs.getUsername
    val projectname: String = gitHubConfigs.projectName
    val token: String = gitHubConfigs.token

    val listIssues = Github(Option(token)).issues.listIssues(username, projectname)

    listIssues.exec[cats.Id, HttpResponse[String]]() match {
      case Left(e) => return None
      case Right(r) => {
        var result: Seq[IssueItem] = Seq()

        r.result.foreach(issue => {
          val id: String = issue.id.toString
          val body: String = issue.body.get
          val assigned: String = ""
          val issueItem = new IssueItem(id, issue.title, "N/A", body, assigned)
          result = result :+ issueItem
        })

        return Some(result)
      }
    }

    return None

  }
}
