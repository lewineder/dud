package dud.model

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class FieldSpec extends AnyWordSpec {
    "A dud field" when {
    "filled with X" should {
      val field1 = new Field(1, 1, Building.Empty)
      val field2 = new Field(2, 2, Building.Empty)
      "have Empty Cells as String" in {
        field1.toString should be("+---------+\n" + "|         |\n" + "|         |\n" + "|         |\n" + "+---------+\n")
        field2.toString should be("+---------++---------+\n" + "|         ||         |\n" + "|         ||         |\n" +
                                  "|         ||         |\n" + "+---------++---------+\n")
      }
    }
      "filled with streets" should {
        val field1 = new Field(1, 1, Building.S1)
        val field2 = new Field(1, 1, Building.H1)
        "have Buidlings as String" in {
          field1.toString should be("+---------+\n" +
            "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n")
          field2.toString should be("+---------+\n" +
            "|    ,^¦  |\n"+ "|   /# #\\ |\n" + "|   |# 1| |\n" + "+---------+\n")
        }
      }
    }
}