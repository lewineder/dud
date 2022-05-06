package dud
package controller

import model.{Field, Building}
import util.Observable

class Controller(var playingField:Field) extends Observable{
    def setPlayer(player: Array[String]): Unit = {
        playingField = playingField.setPlayer(player)
        notifyObservers
    }

    def setBuilding(row: Int, col: Int, building: Building):Unit = {
        playingField = playingField.setBuilding(row-1, col-1, building)
        notifyObservers
    }
    override def toString = playingField.toString
}