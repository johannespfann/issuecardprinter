package de.pfann.issuecardprinter.configuration

trait ConfigBuilder {

  var usernamen: String = ""
  var accessToken: String = ""
  var projectName: String = ""

  def withUsername(username: String): ConfigBuilder
  def withAccessToken(accessToken: String): ConfigBuilder
  def withProjectName(projectName: String): ConfigBuilder

  def build: GitHubConfig
}

class GitHubConfigBuilder extends ConfigBuilder {

  override def withUsername(aUsername: String): ConfigBuilder = {
    usernamen = aUsername
    this
  }

  override def withAccessToken(aAccessToken: String): ConfigBuilder = {
    accessToken = aAccessToken
    this
  }

  override def withProjectName(aProjectName: String): ConfigBuilder = {
    projectName = aProjectName
    this
  }

  override def build: GitHubConfig = {
    new GitHubConfig(this)
  }
}

class GitHubConfig(gitHubConfigBuilder: GitHubConfigBuilder) {

  private var username: String = gitHubConfigBuilder.usernamen
  private var token: String = gitHubConfigBuilder.accessToken
  private var projectName: String = gitHubConfigBuilder.projectName

  def getUsername(): String = {
    username
  }

  def getAccessToken(): String = {
    token
  }

  def getProjectName(): String = {
    projectName
  }
}
