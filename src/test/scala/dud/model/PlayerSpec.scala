package dud.model



import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

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
        player.toString should be ("[1] Gebäude verbleibend für Spieler << Farin >>")
      }
    }
  }
}