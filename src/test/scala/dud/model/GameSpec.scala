package dud;
package model;

import dud.model.BaseIplt.{Building, Field, Game}
import dud.model.move_component.BaseIplt.{Player, Turn}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import util.*


class GameSpec extends AnyWordSpec {
    "A game " when {

        val field1 = new Field(1, 1, Building("Empty"))
        val field2 = new Field(1, 1, Building("S1"))
        val player = Array(Player("Farin", 1), Player("Rod", 1), Player("Bela", 1), Player("Herbert", 1))
        val turn = Turn(0)
        val game = Game(field1, player, turn)
        "filled" should {
            "use the Methods" in {

                game.handle(P1next()).toString should be("Some(Spieler 1 Nächste Strasse setzen)")

                game.toString should include ("[1] Gebäude verbleibend für Spieler << Farin >>")
                game.toString should include ("[1] Gebäude verbleibend für Spieler << Rod >>")
                game.toString should include ("[1] Gebäude verbleibend für Spieler << Bela >>")
                game.toString should include ("[1] Gebäude verbleibend für Spieler << Herbert >>")


                game.setBuilding(0, 0, Building("S1")).toString should be(Game(field2, player, turn).toString)

            }
        }
    }
}