import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*

class fieldSpec extends AnyWordSpec {
  "field" should {
    "Have a scalabel field-Array-generating function of form: '[1][0]..." in {
      genFieldArray(1) should be((0))
      genFieldArray(2) should be((0, 0), (0, 0))
    }

    "Have a mutable field-Array thats acsessed simply" in {
      passNewState(Array.ofDim[Int](1, 1), 0, 0, 1) should be((1))
      passNewState(Array.ofDim[Int](2, 2), 1, 1, 1) should be((0, 0), (0, 1))
    }
  }
}