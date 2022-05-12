package dud
package controller

import model.{Move, Field, Building}
import util.Observable

case class Controller(var playingField: Field) extends Observable{

    val undoManager = new UndoManager[Field]
    def doAndPublish(doThis: Move => Field, move: Move): Unit = {
        playingField = doThis(move)
        notifyObservers
    }
    def setBuilding(move: Move): Field = {
        playingField.setBuilding(move.row-1, move.col-1, move.building)
    }
    override def toString = playingField.toString
}