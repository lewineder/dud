package dud
package model

import game_component.BaseIplt.Turn
import util.{End, InitNew, Interrupt}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import util.*

class TurnSpec extends AnyWordSpec {
  "A Turn" when {
    val turn = new Turn(0)
    "created and given a state" should {
      "print Information about the State" in {
        turn.handle(Play()) should be (turn.gamestate)
        turn.toString should be("Spieler 0 Nächste Strasse setzen")

        turn.handle(InitNew()) should be (turn.gamestate)
        turn.toString should be("Willkommen zu Drunter und Drüber!!!\n 'h' -> help\n\nSpiel startet Spieler 1 bitte erste Strasse am Spielfeldrand setzen")

        turn.handle(Interrupt()) should be (turn.gamestate)
        turn.toString should be("Fehler beim setzen - zurück mit >> y <<")

        turn.handle(End()) should be (turn.gamestate)
        turn.toString should be("✧･ﾟ: *✧･ﾟ:* 　Glückwunsch!!! End of Game　 *:･ﾟ✧*:･ﾟ✧")
      }
    }
  }
}