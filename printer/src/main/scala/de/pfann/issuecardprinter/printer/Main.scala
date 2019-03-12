package de.pfann.issuecardprinter.printer

import de.pfann.issuecardprinter.common.Printer

object Main {

  def main(args: Array[String]): Unit = {
    val printer = new Printer()
    printer.print();
  }

}
