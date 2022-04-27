package observable

import util.Observable
import model.Model

//barely testable
class Controller(var playingField: Array[Array[Int]]) extends Observable{

  //not testable
  def create():Unit = {
    playingField = genFieldMatrix()
    notifyObservers
  }

  //not testable
  def set(row: Int, col: Int, value: Int):Unit = {
    playingField = passNewStateToField(playingField, row, col, value)
    notifyObservers
  }

  //todo: TESTING??
  def toString: String = genStringOfMatrix(playingField)
}