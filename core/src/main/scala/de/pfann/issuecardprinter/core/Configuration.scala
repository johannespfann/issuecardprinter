package de.pfann.issuecardprinter.core

import com.typesafe.config.ConfigFactory
import de.pfann.issuecardprinter.githubissueloader.{GitHubConfig, GitHubConfigBuilder}

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
