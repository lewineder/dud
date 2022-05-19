package dud
package model

import util.*


case class Game (field: Field, players: Array[Player], turn: Turn){


  def handle(event: Event): Option[GameState] =
    turn.handle(event)

  private def playersToString: String =
    val con = for (p <- players) yield p.toString
    con.mkString("\n")



  def setBuilding(row: Int, col: Int, building: Building) : Game =
    copy(field.setBuilding(row, col, building), players, turn)



  override def toString =
    field.toString + "\n" + playersToString + "\n" + turn.toString
}
