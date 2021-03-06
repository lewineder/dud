package dud
package model
package game_component

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import game_component.BaseIplt.Player

class PlayerSpec extends AnyWordSpec {
  "A Player" when {
    val player = Player("Farin", 1)
    "created fresh" should {
      "be able to decrease its Houses" in {
        player.minRemainig should be(Player("Farin", 0))
      }
      "return its remaining Houses" in {
        player.getRemaining should be (1)
      }
      "get a String in Form:" in {
        player.toString should be ("Spieler" + player.name)
      }
    }
  }
}