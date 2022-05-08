package dud.model

case class Field(cells: Array[Array[Building]]) {
    def this(sx: Int, sy: Int, filling: Building) = this(Array.tabulate(sx,sy) { (row, col) => filling})
    val row = cells.length
    val col = cells(0).length
    override def toString = {
        val comb = for {
            c <- cells
            obj <- c
        } yield obj.toString
        val a = comb.mkString("").split("\n").toList
        val output = for {
            i <- 0 to row - 1
            j <- 0 to 4
        } yield skip(a, j+col*5*i , col*5*(i+1), 5)
        val colNumber = for {i <- 1 to row
            } yield output(0 + 5*(i-1)) + "\n" + output(1 + 5*(i-1)) + "\n" + output(2+5*(i-1)) + "     " + i.toString + "\n" + output(3+5*(i-1))+ "\n" + output(4+5*(i-1)) + "\n"
        val rowNumber = for {i <- 1 to col 
            } yield " "*5 + i.toString + " " * 6 
        "\n" + rowNumber.mkString("") + "\n\n" + colNumber.toList.mkString("")
        //colNumber.toList.mkString("\n")

    }

    private def skip(l: List[String], start: Int, end: Int, n: Int): String = {
        val a = for (step <- Range(start, end, n))
            yield l(step)
        a.mkString(" ")
    }

    def setBuilding(row: Int, col: Int, Building: Building): Field =  {
        copy(cells.updated(row, cells(row).updated(col, Building)))
    }

    def getBuilding(x: Int, y: Int): Building = cells(x-1)(y-1)
/*
    def initStart(row: Int, col: Int): Field = {

    }
    */
}
