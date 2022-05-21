package dud
package controller

import model.{Building, Field, Game, GameState, Move, Player, Turn}
import util.*

import scala.language.postfixOps



// ---------------------------------------------------Controller ------------------------------------------------------

case class Controller(var game: Game) extends Observable{

    def handle(event: Event): Option[GameState] =
        game.handle(event)


    def doAndPublish(dothis: Move => Game, move: Move): Unit = {
        game = dothis(move)
        notifyObservers
    }

    def doAndPublish(dothis: => Game) = {
        game = dothis
        notifyObservers
    }




    val undoManager = new UndoManager[Game]

    
    def setBuilding(move: Move): Game = undoManager.doPlacement(game, PutCommand(move))
    def undo: Game = undoManager.undoPlacement(game)
    def redo: Game = undoManager.redoPlacement(game)

    //def setPlayers(s: Array[String]): Array[Player] = for(name <- s) yield Player(name, 0)

    override def toString = game.toString
}

// ---------------------------------------------------------------------------------------------------------------------