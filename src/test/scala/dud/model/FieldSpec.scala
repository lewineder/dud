package dud
package model

import game_component.BaseIplt.{Populate,Building, Field}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class FieldSpec extends AnyWordSpec {
    "A dud field" when {
    "filled with nothing " should {
      val field1 = new Field(1, 1, Building("Ey"))
      val field2 = new Field(1, 2, Building("Ey"))
      "have Empty Cells as String" in {
        field1.toString should be("\n     1      \n\n+---------+\n" + "|         |\n" + "|         |     1\n" + "|         |\n" + "+---------+\n")
        field2.toString should be("\n     1           2      \n\n+---------+ +---------+\n" + "|         | |         |\n" + "|         | |         |     1\n" +                       "|         | |         |\n" + "+---------+ +---------+\n")
      }
    }
      "filled with streets" should {
        val white ="\u001b[0m"
        val color = "\u001b[33m"
        val field1 = new Field(1, 1, Building("S1"))
        val field2 = new Field(1, 1, Building("H1"))
        "have Buidlings as String" in {
          field1.toString should be("\n     1      \n\n+---------+\n" +
            "!_________!\n" + "___________     1\n" + "|         |\n" + "+---------+\n")
          field2.toString should be("\n     1      \n\n+---------+\n" + "|    " + color + ",^¦" + white  + "  |\n"+ "|   " + color +
            "/# #\\" + white  + " |     1\n" + "|   " + color + "|# 1|" + white  + " |\n" + "+---------+\n")
        }
      }
    }
    "A private skip Method" when  {
      "called with nothing" should {
        val list1 = List[String](" ")
        val field1 = new Field(1, 1, Building("Ey"))
        "return a String like:" in {
          field1.skip(list1, 1, 1, 1) should be ("")
        }
      }
    }
    "A setBuilding Method" when {
      "called with nothing" should {
        val field1 = new Field(1, 1, Building("S1"))
        "return a Field like:" in {
          field1.setBuilding(0, 0, Building("S1")).toString should be ("\n     1      \n\n+---------+\n" +
            "!_________!\n" + "___________     1\n" + "|         |\n" + "+---------+\n")
        }
      }
    }
}