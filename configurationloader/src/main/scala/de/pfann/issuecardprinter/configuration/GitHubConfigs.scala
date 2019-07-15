package de.pfann.issuecardprinter.configuration

class GitHubConfigs(val username: String, val token: String, val projectName: String) {

  def getUsername(): String = {
    username
  }

  def getToken(): String = {
    token
  }

  def getProjectName(): String = {
    projectName
  }

}
