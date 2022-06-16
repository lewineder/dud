package dud
package model.game_component

import model.game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import util.GameEvent
import model.game_component.GameState



trait GameInterface {


  def field: Field
  def players: Array[Player]
  def turn: Turn

  def handle(event: GameEvent): Option[GameState]
  def playersToString: String
  def getField(): Field
  def getPlayers(): Array[Player]
  def setBuilding(row: Int, col: Int, building: Building): GameInterface
}

