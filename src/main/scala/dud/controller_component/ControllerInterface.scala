package dud.controller_component

import dud.util.GameEvent
import dud.util.Observable
import dud.model.game_component.GameState
import dud.model.move_component.MoveInterface
import dud.model.game_component.GameInterface
import scala.swing.Publisher

trait ControllerInterface(var game: GameInterface) extends Observable {

  def handle(event: GameEvent): Option[GameState]

  def doAndPublish(dothis: MoveInterface => GameInterface, move: MoveInterface): Unit

  def doAndPublish(dothis: => GameInterface): Unit

  def setBuilding(move: MoveInterface): GameInterface

  def undo: GameInterface

  def redo: GameInterface
}
