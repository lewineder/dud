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
}



