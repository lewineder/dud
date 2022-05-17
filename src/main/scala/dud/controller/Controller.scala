package dud
package controller

import model.{Building, Field, GameState, Move, Player, SaveMove, Turn}
import util.{Command, Event, Observable, UndoManager}

import scala.language.postfixOps



case class Controller(var playingField: Field, var turn: Turn) extends Observable{

    def handle(event: Event): Option[GameState] =
        turn.handle(event)

    def doAndPublish(moveToField: Move => Field, move: Move): Unit = {
        playingField = moveToField(SaveMove(move, playingField.cells))
        notifyObservers
    }
    def doAndPublish(toField: => Field) = {
        playingField = toField
        notifyObservers
    }

    val undoManager = new UndoManager[Field]
    
    def setBuilding(move: Move): Field = undoManager.doPlacement(playingField, PutCommand(move))
    def undo: Field = undoManager.undoPlacement(playingField)
    def redo: Field = undoManager.redoPlacement(playingField)

    def updateTurn(): Unit = { turn = new Turn(playingField.cells, turn.turnsPlayed + 1) } //todo: braucht noch arbeit

    override def toString = playingField.toString + turn.toString()
}