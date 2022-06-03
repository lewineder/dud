package dud.controller_component.BaseIplt

import dud.model.game_component.BaseIplt.{Building, Game}
import dud.model.move_component.BaseIplt.Move
import dud.util.Command

import scala.util.{Command, UndoManager}


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