/*


import dud.model.{Building, Field, Move}
import dud.util.Observer
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class PutCommandSpec extends AnyWordSpec {
  "PutCommand" should {
    val field1 = new Field(1, 1, Building("Empty"))
    val field2 = new Field(1, 1, Building("S2"))
    val command = PutCommand(Move(0, 0, Building("S1")))


    "do nothing to a field in the matrix when called with" in {
      command.noPlacement(field1).toString should be(field1.toString)
      command.doPlacement(field2).toString should be(new Field(1, 1, Building("S1")).toString)
      command.undoPlacement(field2).toString should be(field1.toString)
      command.redoPlacement(field2).toString should be(new Field(1, 1, Building("S1")).toString)
    }
  }
}

*/
