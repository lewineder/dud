package dud
package controller

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import util.Observer

import dud.model.{Building, Field, Move}

class ControllerSpec extends AnyWordSpec {
  "The Controller" should {
    val controller = Controller(new Field(2, 2, Building.Empty))
    "change a field in the matrix when called" in {
      val fieldWithMove = controller.setBuilding(Move(1, 1, Building.H1))
      fieldWithMove.getBuilding(0, 0) should be(Building.H1)
      fieldWithMove.getBuilding(1, 1) should be(Building.Empty)
    }
    "notify its observers on change" in {
      class TestObserver(controller: Controller) extends Observer:
        controller.add(this)
        var bing = false
        def update = bing = true
      val testObserver = TestObserver(controller)
      testObserver.bing should be(false)
      controller.doAndPublish(controller.setBuilding, Move(1, 1, Building.S1))
      testObserver.bing should be(true)
    }
  }
}