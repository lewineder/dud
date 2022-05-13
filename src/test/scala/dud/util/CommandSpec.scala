package dud.util

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class incrCommand extends Command[Int]:
  override def noPlacement(state: Int): Int = state
  override def doPlacement(state: Int): Int = state + 1
  override def undoPlacement(state: Int): Int = state - 1
  override def redoPlacement(state: Int): Int = state + 1

class CommandSpec extends AnyWordSpec {
  "A Command" should {
    val command = new incrCommand
    "have a no placement" in {
      command.noPlacement(0) should be(0)
    }
    "have a do placement" in {
      command.doPlacement(0) should be(1)
      command.doPlacement(1) should be(2)
    }
    "have an undo placement" in {
      command.undoPlacement(1) should be(0)
    }
    "have a redo placement" in {
      command.redoPlacement(1) should be(2)
    }
  }
}
