/*
package dud
package controller

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import util.*
import dud.model.*

class ControllerSpec extends AnyWordSpec {
  "The Controller" should {

    val field1 = new Field(2, 2, Building("Empty"))
    val player = Array(Player("Farin", 1), Player("Rod", 1), Player("Bela", 1), Player("Herbert", 1))
    val turn = Turn(0)
    val controller = Controller(new Game(field1, player, turn))
    "change a field in the matrix when called" in {
      val fieldWithMove = controller.setBuilding(Move(1, 1, Building("H1")))
      fieldWithMove.field.getBuilding(1, 1).toString should be(Building("H1").toString)
      fieldWithMove.field.getBuilding(0, 0).toString should be(Building("Empty").toString)
    }
    "notify its observers on change" in {
      class TestObserver(controller: Controller) extends Observer:
        controller.add(this)
        var bing = false
        def update = bing = true
        def rem = controller.remove(this)

      val testObserver = TestObserver(controller)

      testObserver.bing should be(false)

      controller.doAndPublish(controller.setBuilding, Move(1, 1, Building("S1")))
      testObserver.bing should be(true)

      testObserver.bing = false
      testObserver.rem
      controller.doAndPublish(controller.setBuilding, Move(1, 1, Building("S1")))
      testObserver.bing should be(false)

    }
    "undo and redo" in {
      var game = controller.game
      game.handle(P1next()).toString should be ("Some(Spieler 1 Nächste Strasse setzen)")

      game = controller.setBuilding(Move(0,1, Building("S2")))
      game.field.getBuilding(0, 1).toString should be (Building("S2").toString)
      game = controller.undo
      game.field.getBuilding(0, 1).toString should be (Building("Empty").toString)
      game = controller.redo
      game.field.getBuilding(0, 1).toString should be (Building("S2").toString)
    }
  }
}
*/