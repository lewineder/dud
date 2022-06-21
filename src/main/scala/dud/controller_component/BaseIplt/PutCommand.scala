package dud
package controller_component.BaseIplt

import model.game_component.BaseIplt.{Building, Game}
import model.game_component.GameInterface
import model.move_component.BaseIplt.Move
import util.Command



// ------------------------------------------ Undo-Mechanismus ------------------------------------------------------

class PutCommand(move: List[Move]) extends Command[GameInterface]:
  override def noPlacement(game: GameInterface): GameInterface = game
  override def doPlacement(game: GameInterface): GameInterface = {
    var gameNew = game
    for (i <- 0 until move.size)
      gameNew = gameNew.setBuilding(move(i).row, move(i).col, move(i).building, 0)
    gameNew
  }
  override def undoPlacement(game: GameInterface): GameInterface =
    var gameNew = game
    for (i <- 0 until move.size)
      gameNew = gameNew.setBuilding(move(i).row, move(i).col, Building("Empty"), 2)
    gameNew

  override def redoPlacement(game: GameInterface): GameInterface =
    var gameNew = game
    for (i <- 0 until move.size)
      gameNew = gameNew.setBuilding(move(i).row, move(i).col, move(i).building, 0)
    gameNew
// -------------------------------------------------------------------------------------------------------------------