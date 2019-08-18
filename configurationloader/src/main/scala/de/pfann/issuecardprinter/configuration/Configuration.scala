package de.pfann.issuecardprinter.configuration

import com.typesafe.config.ConfigFactory

class Configuration(val path: String) {

  def load(): GitHubConfig = {
    val defaultConfig = ConfigFactory.parseResources(path)
    new GitHubConfigBuilder()
      .withAccessToken(defaultConfig.getString("githubconfigs.token"))
      .withProjectName(defaultConfig.getString("githubconfigs.projectname"))
      .withUsername(defaultConfig.getString("githubconfigs.username"))
      .build
  }
}
