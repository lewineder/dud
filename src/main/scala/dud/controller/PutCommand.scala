package dud
package controller

import model.{Field, Move, Building}

import util.Command
import util.UndoManager


// ------------------------------------------ Undo-Mechanismus ------------------------------------------------------

class PutCommand(move: Move) extends Command[Field]:
  override def noPlacement(field: Field): Field = field
  override def doPlacement(field: Field): Field = field.setBuilding(move.row, move.col, move.building)
  override def undoPlacement(field: Field): Field = field.setBuilding(move.row, move.col, Building("Empty"))
  override def redoPlacement(field: Field): Field = field.setBuilding(move.row, move.col, move.building)

// -------------------------------------------------------------------------------------------------------------------