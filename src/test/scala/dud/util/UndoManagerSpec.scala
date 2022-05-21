package dud.util

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class UndoManagerSpec extends AnyWordSpec {

  "An UndoManager" should {
    val undoManager = new UndoManager[Int]
    val command = new incrCommand

    "have a do, undo and redo" in {
      var state = 0
      state = undoManager.doPlacement(state, command)
      state should be(1)
      state = undoManager.undoPlacement(state)
      state should be(0)
      state = undoManager.redoPlacement(state)
      state should be(1)
    }

    "handle multiple undo steps correctly" in {
      var state = 0
      state = undoManager.doPlacement(state, command)
      state = undoManager.doPlacement(state, command)
      state should be(2)
      state = undoManager.undoPlacement(state)
      state should be(1)
      state = undoManager.undoPlacement(state)
      state should be(0)
      state = undoManager.redoPlacement(state)
      state should be(1)
    }
  }
}
