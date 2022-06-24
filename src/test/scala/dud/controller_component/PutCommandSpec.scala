package dud;
package controller_component;

import model.game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import model.move_component.BaseIplt.Move
import BaseIplt.PutCommand
import util.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class PutCommandSpec extends AnyWordSpec {
  "PutCommand" should {

    val field1 = new Field(1, 1, Building("Empty"))
    val field2 = new Field(1, 1, Building("S2"))
    val player = Array(Player("Farin", 1), Player("Rod", 1), Player("Bela", 1), Player("Herbert", 1))
    val turn = Turn(0)
    val game = Game(field1, player, turn)
    val game2 = Game(field2, player, turn)
    game.handle(Play())
    game2.handle(Play())

    val command = PutCommand(List[Move](Move(0, 0, Building("S1"))))


    "do nothing to a field in the matrix when called with" in {
      command.noPlacement(game).toString should be(game.toString)
      command.doPlacement(game2).toString should be(Game(new Field(1, 1, Building("S1")), player, turn).toString)
      command.undoPlacement(game2).toString should be(game.toString)
      command.redoPlacement(game2).toString should be(Game(new Field(1, 1, Building("S1")), player, turn).toString)
    }
  }
}


