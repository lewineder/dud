package dud.model.game_component.StubIplt

import dud.model.game_component.BaseIplt.{Building, Field, Player, Turn}
import dud.model.game_component.{GameInterface, GameState}
import dud.util.GameEvent

class Game(field: Field, player: Array[Player], turn: Turn) extends GameInterface {
  case class Game(field: Field, players: Array[Player], turn: Turn) {

    def handle(event: GameEvent): Option[GameState] = turn.handle(event)

    def playersToString: String = ""

    def setBuilding(row: Int, col: Int, building: Building): Game = this

    override def toString = ""
  }

  case class Field()
}
