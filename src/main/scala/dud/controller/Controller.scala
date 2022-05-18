package dud
package controller

import model.{Building, Field, GameState, Move, Player, SaveMove, Turn}
import util.{Command, Event, Observable, UndoManager}

import scala.language.postfixOps



// ---------------------------------------------------Controller ------------------------------------------------------

case class Controller(var playingField: Field, var turn: Turn) extends Observable{

    def handle(event: Event): Option[GameState] =
        turn.handle(event)

    def doAndPublish(moveToField: Move => Field, move: Move): Unit = {
        playingField = moveToField(SaveMove(move, playingField.cells)) //todo: bessere Lösung für Safe-Move finden vllt. mit Monaden try
        turn = doTurn
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

    def doTurn: Turn = Turn(turn.players, turn.turnsPlayed +1)

    override def toString = playingField.toString + turn.toString
}

// ---------------------------------------------------------------------------------------------------------------------