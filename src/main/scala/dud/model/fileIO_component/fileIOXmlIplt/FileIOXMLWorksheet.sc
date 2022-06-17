package dud
package model
package fileIO_component

import game_component.Game

object ioWorksheet {
//  1 + 2
//  val size = 9

  def toXml = {
    <grid size={size.toString}>
    </grid>
  }

  println(toXml)

  val game = new Game(1)
  val filledGrid = grid.set(0, 0, 1)
  println(filledGrid.toString)

  val fileIO = new FileIO(filledGrid)
  val xml = fileIO.gridToXml

}
