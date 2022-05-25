package dud
package model

import util.*


case class Game (field: Field, players: Array[Player], turn: Turn){
  /*
}
  def possibleMove : Set[Move] = {
    lastMove.building match {
      case Building("S1") => Set(Move(lastMove.row, lastMove.col + 1, Building("S1")), (lastStone._1, lastStone._2 - 1, Building("S2")))
      case Building("S2") => Set((lastStone._1, lastStone._2 + 1),
        (lastStone._1 + 1, lastStone._2),
        (lastStone._1, lastStone._2 - 1),
        (lastStone._1 - 1, lastStone._2))
      case Building("S3") => Set((lastStone._1 + 1, lastStone._2), (lastStone._1 - 1, lastStone._2))
    }
  }

  def fitMove(move: Move): Boolean = {
    possibleMove.contains(move)
*/
  def handle(event: GameEvent): Option[GameState] =
    turn.handle(event)

  def playersToString: String =
    val con = for (p <- players) yield p.toString
    con.mkString("\n")



  def setBuilding(row: Int, col: Int, building: Building) : Game =
    copy(field.setBuilding(row, col, building), players, turn)



  override def toString =
    field.toString + "\n" + playersToString + "\n" + turn.toString
}
