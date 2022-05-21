package dud.model;

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import model.{Turn, Player}
import util.*


class GameStateSpec extends AnyWordSpec {
    "an Object" when {
        "made Statable" should {
            val turn = new Turn(0)
            "and return acoordingly" in {
                turn.gamestate should be(None)
                turn.handle(P1next()) should be(turn.gamestate)
            }
        }
    }

    "a Gamestate" when {
        val turn = Turn(0)
        "called" should {
            "print a shoutout to a Player" in {
                Player1(turn).toString should be ("Spieler 1 Nächste Strasse setzen")
                Player2(turn).toString should be ("Spieler 2 Nächste Strasse setzen")
                Player3(turn).toString should be ("Spieler 3 Nächste Strasse setzen")
                Player4(turn).toString should be ("Spieler 4 Nächste Strasse setzen")
                Interrupted(turn).toString should be ("Fehler beim setzen - zurück mit >> y <<")
                Finished(turn).toString should be ("Spiel zu Ende glückwunsch")
                Starting(turn).toString should be ("Spiel startet Spieler 1 bitte erste Strasse am Spielfeldrand setzen")
            }
        }
    }
}