package dud.model;

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec


class GameStateSpec extends AnyWordSpec {
    "an Object" when {
        "made Statable" should {
            val turn = new Turn(0)
            turn.gamestate should be(None)
            turn.handle(P1next()) should be (Option[Player1])
        }
    }
}

class GameStateClassesSpec extends AnyWordSpec {
    "a Gamestate" when {
        "called" should {
            "be printable"
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