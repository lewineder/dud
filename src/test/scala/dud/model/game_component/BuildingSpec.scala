package dud
package model
package game_component

import game_component.BaseIplt.Building
import game_component.BaseIplt.House
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import java.awt.Color

class BuildingSpec extends AnyWordSpec {
  "A dud Building" when {
    "have Buildings" should {
    val s1 = Building("S1")
    val haus2 = Building("H2")
    val haus3 = Building("H3")
    val s2 = Building("S2")
    val s3 = Building("S3")
    val s4 = Building("S4")
    val s5 = Building("S5")
    val ey = Building("Ey")
    "use the methods" in {
      s1.map should be ("/image2b.png")
      s1.name should be ("S1")
      Building("S1").toString should be ("+---------+\n" +
        "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n")

      s2.map should be ( "/image1.png")
      s2.name should be ("S2")
      Building("Ey").toString should be ("+---------+\n" +
        "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n")
      Building("S2").toString should be ("+--| ¦ |--+\n" + "!__| ¦ |__!\n" + 
      "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
      Building("S3").toString should be ("+--| ¦ |--+\n" + "|  | ¦ |o |\n" + "|  | ¦ || |\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"
    )
      Building("S4").toString should be ("+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
      Building("S5").toString should be ("+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")

      s4.map should be ("/image3a.png")
      s4.name should be ("S4")
      s5.map should be ("/image3b.png")
      s5.name should be ("S5")
      s3.map should be ("/image2a.png")
      s3.name should be ("S3")
      ey.map should be ("/empty.png")
      ey.name should be ("Empty")
    }
  }
    "have Houses" should {
      "use the methods" in {
        val h1 = House("H1")
        val h2 = House("H2")
        val h3 = House("H3")
        val h4 = Building("H4").asInstanceOf[House]
        val white = "\u001b[0m"
        val h1color = "\u001b[33m"
        val h2color = "\u001b[32m"
        val h3color = "\u001b[31m"
        val h4color = "\u001b[36m"
        h1.toString should be ("+---------+\n" + "|    " + h1color + ",^¦" + white  + "  |\n"+ "|   " + h1color +
        "/# #\\" + white  + " |\n" + "|   " + h1color + "|# 1|" + white  + " |\n" + "+---------+\n")
        h1.map should be ("/house1.png")
        h1.name should be ("H1")
        h1.colorM.toString should be (Color.red.toString)
        h2.colorM.toString should be (Color.blue.toString)
        h2.map should be ("/house4.png")
        h2.name should be ("H2")
        h2.toString should be ("+---------+\n" + "|   " + h2color + "__" + white  + "    |\n" + "|  " + h2color +
        "/#  \\" + white  + "  |\n" + "|  " + h2color + "|2 ¦|" + white  + "  |\n" + "+---------+\n" + white)
        h3.map should be ("/house2.png")
        h3.colorM.toString should be (Color.green.toString)
        h3.name should be ("H3")
        h3.toString should be ("+---------+\n" + "| " + h3color + "___" + white  + "     |\n" + "| " + h3color +
        "|# \\_" + white  + "   |\n" +"| " + h3color + "|# 3 |" + white  + "  |\n" + "+---------+\n" + white)
        h4.map should be ("/house3.png")
        h4.name should be ("H4")
        h4.colorM.toString should be (Color.yellow.toString)
        h4.toString should be("+---------+\n" + "|     " + h4color + "~°" + white  + "  |\n" + "|  " + h4color +
        ",--|¦." + white  + " |\n" + "|  " + h4color + "|# 4 |" + white  + " |\n" + "+---------+\n" + white)    
      }
    }
  }
}



