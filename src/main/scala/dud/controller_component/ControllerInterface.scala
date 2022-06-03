package dud
package controller_component

import util.GameEvent
import util.Observable
import model.game_component.GameState
import model.move_component.BaseIplt.Move
import model.game_component.GameInterface

trait ControllerInterface(var game: GameInterface) extends Observable {

  def handle(event: GameEvent): Option[GameState]

  def doAndPublish(dothis: List[Move] => GameInterface, move: List[Move]): Unit

  def doAndPublish(dothis: => GameInterface): Unit

  def setBuilding(move: List[Move]): GameInterface

  def undo: GameInterface

  def redo: GameInterface
}
