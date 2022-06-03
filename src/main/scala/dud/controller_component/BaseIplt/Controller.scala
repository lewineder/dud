package dud.controller_component.BaseIplt

import dud.model.game_component.GameInterface
import dud.model.move_component.MoveInterface
import dud.model.game_component.GameState
import dud.util.{GameEvent, Observable, UndoManager}

case class Controller(var game: GameInterface) extends Observable {
  override def handle(event: GameEvent): Option[GameState] =
    game.handle(event)


  override def doAndPublish(dothis: List[MoveInterface] => GameInterface, move: List[MoveInterface]): Unit = {
    game = dothis(move)
    notifyObservers
    //notifyObservers(Event.FieldChanged)
  }

  override def doAndPublish(dothis: => GameInterface) = {
    game = dothis
    notifyObservers
  }


  val undoManager = new UndoManager[GameInterface]

  override def setBuilding(move: List[MoveInterface]): GameInterface = undoManager.doPlacement(game, PutCommand(move))

  override def undo: GameInterface = undoManager.undoPlacement(game)

  override def redo: GameInterface = undoManager.redoPlacement(game)

  //def setPlayers(s: Array[String]): Array[Player] = for(name <- s) yield Player(name, 0)

  override def toString = game.toString
}
