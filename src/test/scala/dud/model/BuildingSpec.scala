package dud.model

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class BuildingSpec extends AnyWordSpec {

  Building("S1").toString should be ("+---------+\n" +
    "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n")
  Building("Empty").toString should be ("+---------+\n" +
    "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n")
}
