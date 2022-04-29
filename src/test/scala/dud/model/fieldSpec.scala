import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*

class fieldSpec extends AnyWordSpec {
  "field" should {
    "have a value Line-Seperator eol" in {
      eol should be (sys.props("line.separator"))
    }

    "Have a genFieldMatrix that returns a matrix of Int" in {
      genFieldMatrix(1) should be (Array(Array(100, 100, 1010, 1001), Array(100, 100, 1011, 0)))
      genFieldMatrix(2) should be (Array(Array(100, 100, 1010, 1001, 1002), Array(100, 100, 1011, 0, 0), Array(100, 100, 1012, 0, 0)))
    }

    "Have a passNewStateToField that changes a single Int " +
      "at a variable position in a matrix and return the changed matrix" in {
      passNewStateToField(Array.ofDim[Int](3,3), 2, 0, 1) should be (Array(Array(0, 0, 0), Array(0, 0, 0), Array(0, 0, 1)))
    }

    "Habe a readyStringsFromArray that takes a Array of Strings as Argument, " +
      "extracts the contents of a whole Array[String] into a single String and returns that String" in {
      readyStringsFromArray(Array("a", "b")) should be ("ab")
      readyStringsFromArray(Array("hallo", "moin")) should be ("hallomoin")
    }

    "Have a readyStringsFromMatrix that takes a matrix of Strings as Argument, " +
      "and extracts the Strings into an Array witch it returns" in {
      readyStringsFromMatrix(Array(Array("a", "b"), Array("c", "d"))) should be (Array("ab", "cd"))
      readyStringsFromMatrix(Array(Array("hallo", "b"), Array("moin", "d"))) should be (Array("hallob", "moind"))
    }


    "Have a genStringsFromMatrix that takes a matrix of Int as Argument " +
      "and turns those into a matrix of Strings. The function is a vital part in generation the field, " +
      "as it uses the genStringFromRow-functions, to turn the matrix-Integers to multi-row ASCII-Form" in {
      genStringsFromMatrix(Array.ofDim[Int](1,1)) should be (Array(Array(("+---------+"), eol,
        ("|         |"), eol,
        ("|         |"), eol,
        ("|         |"), eol,
        ("+---------+"), eol)))
    }

    "Have a genTopStringFromRow that turns an Array of Int " +
      "as argument into an Array of String as return"  in {
      genTopStringFromRow(Array(0)) should be (Array("+---------+"))
      genTopStringFromRow(Array(0, 0)) should be (Array(("+---------+"),("+---------+")))
    }

    "Have a fontOfElement that takes an Int as args and returns a String" in {
      fontOfElement(1) should be ("+---------+")
      fontOfElement(10) should be ("+--| ¦ |--+")
      fontOfElement(12) should be ("+--| ¦ |--+")
      fontOfElement(100) should be ("           ")
      fontOfElement(223452345) should be ("+---------+")
    }

    "Have a genBodyStringFromRow that takes a Int as args and returns three Strings in an Array" in {
      genBodyStringFromRow(Array.ofDim[Int](1)) should be (Array(("|         |"), eol
        , ("|         |"), eol, ("|         |"),  eol))
      genBodyStringFromRow(Array(1)) should be (Array("|    ,^¦  |", eol, "|   /# #\\ |", eol, "|   |# 1| |", eol))
      genBodyStringFromRow(Array(0, 0)) should be (Array("|         |", "|         |",
        eol, "|         |", "|         |",  eol, "|         |", "|         |", eol))
    }

    "Have top/mid/bot/StringOfElement-functions that returns a String for every Int you pass in args" in {
      topStringOfElement(0) should be ("|         |")

      topStringOfElement(1) should be ("|    ,^¦  |")
      topStringOfElement(2) should be ("|   __    |")
      topStringOfElement(3) should be ("| ___     |")
      topStringOfElement(4) should be ("|     ~°  |")

      topStringOfElement(10) should be ("!__| ¦ |__!")
      topStringOfElement(11) should be ("!_________!")
      topStringOfElement(12) should be ("|  | ¦ |o |")

      topStringOfElement(100) should be ("           ")
      topStringOfElement(1011) should be ("       ^   ")
      topStringOfElement(223452345) should be ("           ")


      midStringOfElement(1) should be ("|   /# #\\ |")
      midStringOfElement(0) should be ("|         |")
      midStringOfElement(2) should be ("|  /#  \\  |")
      midStringOfElement(3) should be ("| |# \\_   |")
      midStringOfElement(4) should be ("|  ,--|¦. |")

      midStringOfElement(10) should be ("___     ___")
      midStringOfElement(11) should be ("___________")
      midStringOfElement(12) should be ("|  | ¦ || |")

      midStringOfElement(100) should be ("           ")

      midStringOfElement(1011) should be ("       1   ")
      midStringOfElement(1012) should be ("       2   ")
      midStringOfElement(1013) should be ("       3   ")
      midStringOfElement(1014) should be ("       4   ")
      midStringOfElement(1015) should be ("       5   ")
      midStringOfElement(1016) should be ("       6   ")
      midStringOfElement(1017) should be ("       7   ")

      midStringOfElement(12345) should be ("           ")




      botStringOfElement(0) should be ("|         |")
      botStringOfElement(1) should be ("|   |# 1| |")
      botStringOfElement(2) should be ("|  |2 ¦|  |")
      botStringOfElement(3) should be ("| |# 3 |  |")
      botStringOfElement(4) should be ("|  |# 4 | |")

      botStringOfElement(10) should be ("|  | ¦ |  |")
      botStringOfElement(11) should be ("|         |")
      botStringOfElement(12) should be ("|  | ¦ |  |")

      botStringOfElement(100) should be ("           ")

      botStringOfElement(1001) should be ("  .< 1 >.  ")
      botStringOfElement(1002) should be ("  .< 2 >.  ")
      botStringOfElement(1003) should be ("  .< 3 >.  ")
      botStringOfElement(1004) should be ("  .< 4 >.  ")
      botStringOfElement(1005) should be ("  .< 5 >.  ")
      botStringOfElement(1006) should be ("  .< 6 >.  ")
      botStringOfElement(1007) should be ("  .< 7 >.  ")

      botStringOfElement(1011) should be ("       v   ")

      botStringOfElement(223452345) should be ("           ")
    }
  }
}