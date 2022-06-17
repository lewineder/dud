package dud
package model.game_component.BaseIplt

import util.GameEvent
import model.game_component.GameState
import model.game_component.GameInterface
import com.google.inject.Inject


case class Game (field: Field, players: Array[Player], turn: Turn) extends GameInterface {

  @Inject
  def this() = this(field = new Field(8, 8, Building("Empty")), players = Array(Player("1", 0), Player("2", 0), Player("3", 0), Player("4", 0)), turn = Turn(1))

  def handle(event: GameEvent): Option[GameState] =
    turn.handle(event)

  def playersToString: String =
    val con = for (p <- players) yield p.toString
    con.mkString("\n")

  def setBuilding(row: Int, col: Int, building: Building): Game =
    copy(field.setBuilding(row, col, building), players, turn)

  def getField(): Field = this.field
  def getPlayers(): Array[Player] = this.players

  override def toString: String =
    field.toString + "\n" + playersToString + "\n" + turn.toString
}
