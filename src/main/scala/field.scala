
def genFieldMatrix(i: Int = 10): Array[Array[Int]] =
    Array.ofDim[Int](i, i)

def passNewStateToField(matrix: Array[Array[Int]], i: Int = 0, j: Int = 0, value: Int = 0): Array[Array[Int]] =
    matrix(i)(j) = value
    matrix

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
    "+---------+"

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
    "|         |"

def midStringOfElement(number: Int): String =
    "|         |"

def botStringOfElement(number: Int): String =
    "|         |"