package dud.model.game_component
package BaseIplt

import dud.util.GameEvent

case class Game(field: Field, players: Array[Player], turn: Turn) extends GameInterface {
  
  def handle(event: GameEvent): Option[GameState] =
    turn.handle(event)

  def playersToString: String =
    val con = for (p <- players) yield p.toString
    con.mkString("\n")
  
  def setBuilding(row: Int, col: Int, building: Building): Game =
    copy(field.setBuilding(row, col, building), players, turn)

  def getField(): Field = this.field
  
  override def toString: String =
    field.toString + "\n" + playersToString + "\n" + turn.toString
}
