package de.pfann.issuecardprinter.printer

import github4s.Github
import github4s.Github._
import github4s.jvm.Implicits._
import scalaj.http.HttpResponse


object GitHubTest {

  val accessToken: Option[String] = Option("blabla")

  def main(args: Array[String]): Unit = {
    val user1 = Github(accessToken).users.get("johannespfann")

    user1.exec[cats.Id, HttpResponse[String]]() match {
      case Left(e) => println(s"Something went wrong: ${e.getMessage}")
      case Right(r) => {
        println("Result    :" + r.result.id)
        println("StatusCode:" + r.statusCode)
      }
    }

    val getRepo = Github(accessToken).repos.listUserRepos("johannespfann")

    getRepo.exec[cats.Id, HttpResponse[String]]() match {
      case Left(e) => println(s"Something went wrong: ${e.getMessage}")
      case Right(r) => r.result.foreach(repo => println(repo.name))
      }
    }

    val listIssues = Github(accessToken).issues.listIssues("johannespfann", "budgetmanager-server")

    listIssues.exec[cats.Id, HttpResponse[String]]() match {
      case Left(e) => println(s"Something went wrong: ${e.getMessage}")
      case Right(r) => r.result.foreach( issue => {
        println(issue.title)
      })
    }


  }


}
