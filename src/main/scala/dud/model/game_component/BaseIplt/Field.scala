package dud.model.game_component.BaseIplt

import com.google.inject.Inject

//------------------------------------------------------------- Private --------------------------------------------------
//tested
case class Field(cells: Array[Array[Building]]) {
  
  def this (sx: Int, sy: Int, filling: Building) = this(Populate(Array.tabulate(sx, sy) { (row, col) => filling }))

  val row: Int = cells.length
  val col: Int = cells(0).length

  override def toString = {
    val comb = for {
      c <- cells
      obj <- c
    } yield obj.toString

    val a = comb.mkString("").split("\n").toList

    val output = for {
      i <- 0 until row
      j <- 0 to 4
    } yield skip(a, j + col * 5 * i, col * 5 * (i + 1), 5)

    val colNumber = for {i <- 1 to row
                         } yield output(0 + 5 * (i - 1)) + "\n" + output(1 + 5 * (i - 1)) + "\n" + output(2 + 5 * (i - 1)) + "     " + i.toString + "\n" + output(3 + 5 * (i - 1)) + "\n" + output(4 + 5 * (i - 1)) + "\n"
    val rowNumber = for {i <- 1 to col
                         } yield " " * 5 + i.toString + " " * 6

    "\n" + rowNumber.mkString("") + "\n\n" + colNumber.toList.mkString("")
  }

  def skip(l: List[String], start: Int, end: Int, n: Int): String = {
    val skip = for (step <- Range(start, end, n))
      yield l(step)
    skip.mkString(" ")
  }

  //--------------------------------------------------------------------- Public ----------------------------------------
  //tested
  def setBuilding(row: Int, col: Int, Building: Building): Field = copy(cells.updated(row, cells(row).updated(col, Building)))

  def getBuilding(x: Int, y: Int): Building = cells(x)(y)
}

//-----------------------------------------------------------------------Singleton-----------------------------------------
object Populate{
  def apply(matrix: Array[Array[Building]]): Array[Array[Building]] =
    val row = matrix.length
    val col = matrix(0).length
    val rd = scala.util.Random.shuffle(0.until(col * row))
    for (i <- 0 until (((row * col) / 20) * 4)) {
      matrix(rd(i) / col)(rd(i) % col) = getBuild(i % 4)
    }
    matrix

  def getBuild = Array(Building("H1"), Building("H2"), Building("H3"), Building("H4"))
}
//--------------------------------------------------------------------------------------------------------------------------
