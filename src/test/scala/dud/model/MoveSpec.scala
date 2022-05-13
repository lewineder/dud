package dud.model

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class MoveSpec extends AnyWordSpec{
  "A Move" should  {
    "have a col, row with a building" in {
      val move = Move(1, 2, Building.S1)
      move.row should be(1)
      move.col should be(2)
      move.building should be(Building.S1)
    }
  }
}
