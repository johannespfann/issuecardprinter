package de.pfann.issuecardprinter.core

import com.typesafe.config.ConfigFactory
import de.pfann.issuecardprinter.githubissueloader.{GitHubConfig, GitHubConfigBuilder}
import de.pfann.issuecardprinter.printer.PrinterConfig

class Configuration(val path: String) {

  def loadGitHubConfig(): GitHubConfig = {
    val defaultConfig = ConfigFactory.parseResources(path)
    new GitHubConfigBuilder()
      .withAccessToken(defaultConfig.getString("githubconfigs.token"))
      .withProjectName(defaultConfig.getString("githubconfigs.projectname"))
      .withUsername(defaultConfig.getString("githubconfigs.username"))
      .build
  }

  def loadFilePrinterConfig(): PrinterConfig = {
    val defaultConfig = ConfigFactory.parseResources(path)
    new PrinterConfig(
      defaultConfig.getString("fileprinterconfig.filetemplatepath"),
      defaultConfig.getString("fileprinterconfig.outputpath"))
  }

}
