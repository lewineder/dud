package dud
package controller

import model.{Game, Move, Building}

import util.Command
import util.UndoManager


// ------------------------------------------ Undo-Mechanismus ------------------------------------------------------

class PutCommand(move: Move) extends Command[Game]:
  override def noPlacement(game: Game): Game = game
  override def doPlacement(game: Game): Game = game.setBuilding(move.row, move.col, move.building)
  override def undoPlacement(game: Game): Game = game.setBuilding(move.row, move.col, Building("Empty"))
  override def redoPlacement(game: Game): Game = game.setBuilding(move.row, move.col, move.building)

// -------------------------------------------------------------------------------------------------------------------
