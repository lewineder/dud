package dud.controller_component
package StubIplt

import dud.model.game_component.GameInterface
import dud.model.move_component.MoveInterface
import dud.model.move_component.BaseIplt.Move

class Controller(var game: GameInterface) extends ControllerInterface {
  val move = Move(1,1, Building("S1"))
  override def handle(event: GameEvent): Option[GameState] = game.handle(event)
  override def doAndPublish(dothis: List[MoveInterface] => GameInterface, move: List[MoveInterface]): Unit = {}
  override def doAndPublish(dothis: => GameInterface): Unit = {}
  override def setBuilding(move: List[MoveInterface]): GameInterface = game
}
