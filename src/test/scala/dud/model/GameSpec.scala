package dud
package model

import game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import util.*


class GameSpec extends AnyWordSpec {
    "A game " when {

        val field1 = new Field(4, 4, Building("Ey"))
        val field2 = new Field(1, 1, Building("Ey"))
        val field3 = new Field(1, 1, Building("S1"))
        val player = Array(Player("Farin", 1), Player("Rod", 1), Player("Bela", 1), Player("Herbert", 1))
        val turn = Turn(1)
        val game = Game(field1, player, turn)
        val game2 = Game(field2, player, turn)
        "filled" should {
            "use the Methods" in {

                game.handle(Play()).toString should be("Some(Spieler 1 Nächste Strasse setzen)")

                game.toString should include ("SpielerFarin:  Points = 0")
                game.toString should include ("SpielerRod:  Points = 0")
                game.toString should include ("SpielerBela:  Points = 0")
                game.toString should include ("SpielerHerbert:  Points = 0")

                game2.setBuilding(0, 0, Building("S1")).toString should be(Game(field3, player, turn).toString)

            }
        }
    }
}