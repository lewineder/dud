package dud
package controller

import model.{Move, Building, Field}
import util.Observable
import util.Command
import util.UndoManager

case class Controller(var playingField: Field) extends Observable{

    val undoManager = new UndoManager[Field]
    
    def doAndPublish(doThis: Move => Field, move: Move): Unit = {
        playingField = doThis(move)
        notifyObservers
    }
    def doAndPublish(doThis: => Field) = {
        playingField = doThis
        notifyObservers
    }
    def setBuilding(move: Move): Field = undoManager.doPlacement(playingField, PutCommand(move))
    
    def undo: Field = undoManager.undoPlacement(playingField)
    def redo: Field = undoManager.redoPlacement(playingField)
    
    override def toString = playingField.toString
}