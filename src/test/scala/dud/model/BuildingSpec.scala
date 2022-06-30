package dud
package model

import game_component.BaseIplt.Building
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class BuildingSpec extends AnyWordSpec {

  Building("S1").toString should be ("+---------+\n" +
    "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n")
  Building("Ey").toString should be ("+---------+\n" +
    "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n")
  Building("S2").toString should be ("+--| ¦ |--+\n" + "!__| ¦ |__!\n" + 
  "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
  Building("S3").toString should be ("+--| ¦ |--+\n" + "|  | ¦ |o |\n" + "|  | ¦ || |\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"
)
  Building("S4").toString should be ("+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
  Building("S5").toString should be ("+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
}



