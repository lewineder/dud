val eol: String =
  sys.props("line.separator")

def genFieldMatrix(i: Int = 7): Array[Array[Int]] =
    val arr = Array.ofDim[Int](i + 1, i + 3)
    for(index <- 0 until 8)
      arr(index)(0) = 100
      arr(index)(1) = 100
      arr(0)(index + 2) = 1000 + index
      arr(index)(2) = 1010 + index
    return arr


def passNewStateToField(matrix: Array[Array[Int]], i: Int = 0, j: Int = 0, value: Int = 0): Array[Array[Int]] =
    matrix(i)(j + 2) = value
    return matrix

def readyStringsFromArray(stringArray: Array[String]): String =
    stringArray.mkString

def readyStringsFromMatrix(matrix: Array[Array[String]]): Array[String] =
    for {row <- matrix} yield {
      row.mkString
    }

def genStringsFromMatrix(matrix: Array[Array[Int]]): Array[Array[String]] =
    for { row  <- matrix } yield {
        (genTopStringFromRow(row) :+ eol) ++
        genBodyStringFromRow(row) ++
        (genTopStringFromRow(row) :+ eol)
    }

def genTopStringFromRow(numberArray: Array[Int]): Array[String] =
    for { element <- numberArray } yield {
        fontOfElement(element)
    }

def fontOfElement(number: Int): String =
  number match {
    case 10 => "+--| ¦ |--+"
    case 12 => "+--| ¦ |--+"
    case 100 => "           "
    case x if 1000 until 1020 contains x => "           "
    case _ => "+---------+"
  }


def genBodyStringFromRow(numberArray: Array[Int]): Array[String] =
      ((for {element <- numberArray} yield {
          topStringOfElement(element)
      }) :+ eol) ++
      ((for {element <- numberArray} yield {
          midStringOfElement(element)
      }) :+ eol) ++
      ((for {element <- numberArray} yield {
          botStringOfElement(element)
      }) :+ eol)


def topStringOfElement(number: Int): String =
  number match {
    case 0 => "|         |"
    case 1 => "|    ,^¦  |"
    case 2 => "|   __    |"
    case 3 => "| ___     |"
    case 4 => "|     ~°  |"
    case 10 => "!__| ¦ |__!"
    case 11 => "!_________!"
    case 12 => "|  | ¦ |o |"
    case 100 => "           "
    case x if 1011 until 1020 contains x => "       ^   "
    case _ => "           "
  }
def midStringOfElement(number: Int): String =
  number match {
    case 0 => "|         |"
    case 1 => "|   /# #\\ |"
    case 2 => "|  /#  \\  |"
    case 3 => "| |# \\_   |"
    case 4 => "|  ,--|¦. |"
    case 10 => "___     ___"
    case 11 => "___________"
    case 12 => "|  | ¦ || |"
    case 100 => "           "
    case 1011 => "       1   "
    case 1012 => "       2   "
    case 1013 => "       3   "
    case 1014 => "       4   "
    case 1015 => "       5   "
    case 1016 => "       6   "
    case 1017 => "       7   "
    case _ => "           "
  }

def botStringOfElement(number: Int): String =
  number match {
    case 0 => "|         |"
    case 1 => "|   |# 1| |"
    case 2 => "|  |2 ¦|  |"
    case 3 => "| |# 3 |  |"
    case 4 => "|  |# 4 | |"
    case 10 => "|  | ¦ |  |"
    case 11 => "|         |"
    case 12 => "|  | ¦ |  |"
    case 100 => "           "
    case 1001 => "  .< 1 >.  "
    case 1002 => "  .< 2 >.  "
    case 1003 => "  .< 3 >.  "
    case 1004 => "  .< 4 >.  "
    case 1005 => "  .< 5 >.  "
    case 1006 => "  .< 6 >.  "
    case 1007 => "  .< 7 >.  "
    case x if 1011 until 1020 contains x => "       v   "
    case _ => "           "
  }