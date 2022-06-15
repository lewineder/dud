package dud
package model

import game_component.BaseIplt.Building
import move_component.BaseIplt.Move
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class MoveSpec extends AnyWordSpec{
  "A Move" should  {
    "have a col, row with a building" in {
      val move = Move(1, 2, Building("S1"))
      move.row should be(1)
      move.col should be(2)
      move.building.toString should be (Building("S1").toString)
    }
  }
}
