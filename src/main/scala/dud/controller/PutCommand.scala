package dud
package controller

import model.{Game, Move, Building}

import util.Command
import util.UndoManager


// ------------------------------------------ Undo-Mechanismus ------------------------------------------------------

class PutCommand(move: List[Move]) extends Command[Game]:
  override def noPlacement(game: Game): Game = game
  override def doPlacement(game: Game): Game = {
    var gameNew = game
    for (i <- 0 until move.size)
      gameNew = gameNew.setBuilding(move(i).row, move(i).col, move(i).building)
    gameNew
  }
  override def undoPlacement(game: Game): Game = 
    var gameNew = game
    for (i <- 0 until move.size)
      gameNew = gameNew.setBuilding(move(i).row, move(i).col, Building("Empty"))
    gameNew

  override def redoPlacement(game: Game): Game = 
    var gameNew = game
    for (i <- 0 until move.size)
      gameNew = gameNew.setBuilding(move(i).row, move(i).col, move(i).building)
    gameNew
// -------------------------------------------------------------------------------------------------------------------