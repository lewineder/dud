package dud
package model

import game_component.{Finished, Interrupted, Playing, Starting}
import game_component.BaseIplt.{Player, Turn}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import util.*


class GameStateSpec extends AnyWordSpec {
    "an Object" when {
        "made Statable" should {
            val turn = new Turn(0)
            "and return acoordingly" in {
                turn.gamestate should be(None)
                turn.handle(Play()) should be(turn.gamestate)
            }
        }
    }

    "a Gamestate" when {
        val turn = Turn(1)
        "called" should {
            "print a shoutout to a Player" in {
                Playing(turn).toString should be ("Spieler 1 Nächste Strasse setzen")
                Interrupted(turn).toString should be ("Fehler beim setzen - zurück mit >> y <<")
                Finished(turn).toString should be ("✧･ﾟ: *✧･ﾟ:* 　Glückwunsch!!! End of Game　 *:･ﾟ✧*:･ﾟ✧")
                Starting(turn).toString should be ("Willkommen zu Drunter und Drüber!!!\n 'h' -> help\n\nSpiel startet Spieler 1 bitte erste Strasse am Spielfeldrand setzen")
            }
        }
    }
}