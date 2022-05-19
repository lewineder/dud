/*package dud.aview

import dud.model.*
import dud.controller.*

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec {
  "The Tui" should {
    val controller = Controller(new Field(1,1,Building("Empty")))
    val tui = Tui(controller)
    "recognize the input 'y' as a undo-call" in {
      tui.getInputLine("y") should be(None)
    }
    "recognize the input 'z' as a redo-call" in {
      tui.getInputLine("z") should be(None)
    }
    "recognize the input 1 1 S1 as switch of an empty field to field (S1)" in {
      tui.getInputLine("1 1 S1") should be(Some(Move(0, 0, Building("S1"))))
    }

    "and following lines:" in {
      tui.getInputLine("1 1 S2") should be(Some(Move(0, 0, Building("S2"))))
      tui.getInputLine("1 1 S3") should be(Some(Move(0, 0, Building("S3"))))
      tui.getInputLine("1 1 H1") should be(Some(Move(0, 0, Building("H1"))))
      tui.getInputLine("1 1 H2") should be(Some(Move(0, 0, Building("H2"))))
      tui.getInputLine("1 1 H3") should be(Some(Move(0, 0, Building("H3"))))
      tui.getInputLine("1 1 H4") should be(Some(Move(0, 0, Building("H4"))))
    }
  }
}


 */