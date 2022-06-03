package dud.model.game_component

import dud.model.*
import dud.model.game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import dud.util.GameEvent
import dud.util.GameEvent


trait GameInterface {
  def getField(): Field
  def handle(event: GameEvent): Option[GameState]
  def playersToString: String
  def setBuilding(row: Int, col: Int, building: Building): GameInterface
}

