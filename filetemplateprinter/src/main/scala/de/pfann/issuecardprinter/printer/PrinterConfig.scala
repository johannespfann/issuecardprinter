package de.pfann.issuecardprinter.printer


class PrinterConfig(val aPathToTemplate: String, val aOutputPath: String) {

  val pathToTemplate: String = aPathToTemplate
  val outputPath: String = aOutputPath

  require(!pathToTemplate.isEmpty)
  require(!outputPath.isEmpty)

  def getPathToTemplate(): String  = {
    pathToTemplate
  }


  def getOutputPath(): String  = {
    outputPath
  }

}
