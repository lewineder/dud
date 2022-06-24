package dud
package model.game_component.BaseIplt

import util.GameEvent
import dud.util.*
import model.game_component.GameState
import model.game_component.GameInterface
import com.google.inject.Inject
import scala.language.postfixOps


case class Game (field: Field, players: Array[Player], turn: Turn) extends GameInterface {

  @Inject
  def this() = this(field = new Field(8, 8, Building("Ey")), players = Array(Player("1", 0), Player("2", 0), Player("3", 0), Player("4", 0)), turn = Turn(1))

  def handle(event: GameEvent): Option[GameState] =
    turn.handle(event)

  def playersToString: String =
    val con = for (p <- players) yield p.toString
    con.mkString("\n")

  def setBuilding(row: Int, col: Int, building: Building): Game =
    copy(field.setBuilding(row, col, building), players, turn)

  def setTurn(skip: Int): Turn = 
    turn.setTurn(skip)

  def getField(): Field = this.field
  def getPlayers(): Array[Player] = this.players

  def countPoints(player: Int): Int = 
    val count = Array(0,0,0,0)
    for {i <- 0 until field.col; j <- 0 until field.row}
      field.getBuilding(i,j) match{
        case h: Haus1 => count(0) += 1
        case h: Haus2 => count(1) += 1
        case h: Haus3 => count(2) += 1
        case h: Haus4 => count(3) += 1
        case _ =>
      }
    for (c <- count)
      if (c == 0) handle(End())
    count(player)


  def pointsToString(): IndexedSeq[String] = 
    for {i <- 0 until players.length} yield players(i).toString + ":  Points = " + countPoints(i)
  
  override def toString: String =
    field.toString + "\n" + pointsToString().mkString("\n") + "\n\n" + turn.toString
}