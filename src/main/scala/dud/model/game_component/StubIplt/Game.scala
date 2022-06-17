/*package dud
package model.game_component.StubIplt

import model.game_component.BaseIplt.{Building, Field, Player, Turn}
import model.game_component.{GameInterface, GameState}
import util.GameEvent

class Game (field: Field, player: Array[Player], turn: Turn) extends GameInterface {

    override def handle(event: GameEvent): Option[GameState] = turn.handle(event)

    override def setBuilding(row: Int, col: Int, building: Building): Game = this

    override def getField(): Field = field
    override def getPlayers(): Array[Player] = player

    override def playersToString: String = ""
    override def toString = ""
}
*/