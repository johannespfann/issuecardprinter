package de.pfann.issuecardprinter.printer


class PrinterConfig(val aPathToTemplate: String, val aOutputPath: String) {

  require(!pathToTemplate.isEmpty)
  require(!outputPath.isEmpty)

  println("init PrinterConfig")

  val pathToTemplate: String = aPathToTemplate
  val outputPath: String = aOutputPath


  def getPathToTemplate(): String  = {
    pathToTemplate
  }


  def getOutputPath(): String  = {
    outputPath
  }

}
