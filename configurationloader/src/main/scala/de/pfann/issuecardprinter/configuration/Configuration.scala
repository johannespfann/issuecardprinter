package de.pfann.issuecardprinter.configuration

import com.typesafe.config.ConfigFactory


class Configuration(val path: String) {

  def load(): GitHubConfigs = {

    val defaultConfig = ConfigFactory.parseResources(path)

    val name = defaultConfig.getString("githubconfigs.username")
    val project = defaultConfig.getString("githubconfigs.projectname")
    val accessToken = defaultConfig.getString("githubconfigs.token")

    val gitHubConfigs = new GitHubConfigs(name,accessToken,project)
    println(gitHubConfigs.projectName)
    println(gitHubConfigs.token)
    println(gitHubConfigs.username)
    gitHubConfigs

  }




}
