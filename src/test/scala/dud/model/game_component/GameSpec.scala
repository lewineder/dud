package dud
package model
package game_component

import dud.util.Play
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import game_component.BaseIplt.{Field, Turn, Building, Game, Player}

import scala.util.*


class GameSpec extends AnyWordSpec {
    "A game " when {

        val field1 = new Field(4, 4, Building("Ey"))
        val field2 = new Field(1, 1, Building("Ey"))
        val field3 = new Field(1, 1, Building("S1"))
        val player = Array(Player("Farin", 1), Player("Rod", 1), Player("Bela", 1), Player("Herbert", 1))
        val turn = Turn(1)
        val game = Game(field1, player, turn)
        val game2 = Game(field2, player, turn)
        val game3 = Game
        "filled" should {
            "use the Methods" in {

                game.handle(Play()).toString should be("Some(Spieler 1 Nächste Strasse setzen)")
                game.playersToString should be ("SpielerFarin\nSpielerRod\nSpielerBela\nSpielerHerbert")
                game.toString should include ("SpielerFarin:  Points = 0")
                game.toString should include ("SpielerRod:  Points = 0")
                game.toString should include ("SpielerBela:  Points = 0")
                game.toString should include ("SpielerHerbert:  Points = 0")
                game.getField().toString should be (game.field.toString)
                game.getPlayers().toString should be (game.players.toString)
                game2.setBuilding(0, 0, Building("S1")).toString should be(Game(field3, player, turn).toString)

            }
        }
    }
}