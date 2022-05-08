package dud.model

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec extends AnyWordSpec {
  Player("Robert Lewandowski") should be ("Robert Lewandowski")
  Player("Carles Puyol") should be ("Carles Puyol")
}
