package dud.model



import dud.model.{Building, Field}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class PhantomPlayerSpec extends AnyWordSpec {
  "A Phantom" when {
    "called with matrix " should {
      val arr1 = Array.tabulate(1,1) { (row, col) => Building.Empty}
      val arr2 = Array.tabulate(1,2) { (row, col) => Building.Empty}
      "return an Empty Matrix as it is too small to fill" in {
        PhantomPlayer(arr1) should be(arr1)
        PhantomPlayer(arr2) should be(arr2)
      }
      "calling getBuild" should {
        PhantomPlayer.getBuild should be(Array(Building.H1, Building.H2, Building.H3, Building.H4))
      }
    }
  }
}



