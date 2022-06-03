package dud
package controller_component.StubIplt

import model.game_component.GameInterface
import dud.controller_component.ControllerInterface
import model.game_component.GameState
import model.game_component.BaseIplt.Building
import model.move_component.BaseIplt.Move
import util.GameEvent

class Controller(var game: GameInterface) extends ControllerInterface {
  val move = Move(1,1, Building("S1"))
  override def handle(event: GameEvent): Option[GameState] = game.handle(event)
  override def doAndPublish(dothis: List[Move] => GameInterface, move: List[Move]) :Unit = {}
  override def doAndPublish(dothis: => GameInterface): Unit = {}
  override def setBuilding(move: List[Move]): GameInterface = game
  override def undo: GameInterface = game
  override def redo: GameInterface = game
}
