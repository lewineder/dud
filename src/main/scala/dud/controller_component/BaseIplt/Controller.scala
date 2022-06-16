package dud
package controller_component
package BaseIplt

import com.google.inject.{Guice, Inject}
import model.game_component.GameInterface
import model.game_component.BaseIplt.Game
import model.move_component.BaseIplt.Move
import model.game_component.GameState
import util.*

case class Controller @Inject() (var game: GameInterface) extends ControllerInterface {

  def handle(event: GameEvent): Option[GameState] =
    game.handle(event)

  def doAndPublish(dothis: List[Move] => GameInterface, move: List[Move]): Unit = {
    game = dothis(move)
    notifyObservers
  }

  def doAndPublish(dothis: => GameInterface) = {
    game = dothis
    notifyObservers
  }


  val undoManager = new UndoManager[GameInterface]

  def setBuilding(move: List[Move]): GameInterface = undoManager.doPlacement(game, PutCommand(move))

  def undo: GameInterface = undoManager.undoPlacement(game)

  def redo: GameInterface = undoManager.redoPlacement(game)

  override def toString = game.toString
}
