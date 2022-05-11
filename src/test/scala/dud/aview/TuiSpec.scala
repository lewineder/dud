package dud.aview

import dud.model.*
import dud.controller.Controller

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class TuiSpec extends AnyWordSpec {

  "The Tui" should {
    val tui = Tui(Controller(new Field(1, 1, Building.Empty)))
    "recognize the input 11 S1 as switch of an empty field to field (S1)" in {
      tui.getInputLine("11 S1") should be(Some(Move(1, 1, Building.S1)))
    }
    "and following lines:" in {
      tui.getInputLine("11 S2") should be(Some(Move(1, 1, Building.S2)))
      tui.getInputLine("11 S3") should be(Some(Move(1, 1, Building.S3)))
      tui.getInputLine("11 H1") should be(Some(Move(1, 1, Building.H1)))
      tui.getInputLine("11 H2") should be(Some(Move(1, 1, Building.H2)))
      tui.getInputLine("11 H3") should be(Some(Move(1, 1, Building.H3)))
      tui.getInputLine("11 H4") should be(Some(Move(1, 1, Building.H4)))
    }
  }
}