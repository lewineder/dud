package dud.model

case class Field(cells: Array[Array[Building]]) {
    def this(sx: Int, sy: Int, filling: Building) = this((Array.tabulate(sx,sy) { (row, col) => filling}))

    val row: Int = cells.length
    val col: Int = cells(0).length
    override def toString = {
                "\n" + getRowNum.mkString("") + "\n\n" + getColNum.toList.mkString("")
    }


    //---------------------------------------------- P R I V A T E ----------------------------------------------------

    private def getColNum = for {i <- 1 to row} yield
        getOutput(0 + 5 * (i - 1)) + "\n" +
        getOutput(1 + 5 * (i - 1)) + "\n" +
        getOutput(2 + 5 * (i - 1)) + "     " + i.toString + "\n" +
        getOutput(3 + 5 * (i - 1))+ "\n" +
        getOutput(4 + 5 * (i - 1)) + "\n"


    private def getRowNum = for {i <- 1 to col} yield " " * 5 + i.toString + " " * 6


    private def getComb =  for {
        c <- cells
        obj <- c
    } yield obj.toString


    private def getOutput = for {
        i <- 0 until row
        j <- 0 to 4
    } yield skip(getComb.mkString("").split("\n").toList, j + col * 5 * i , col * 5 * (i + 1), 5)


    private def skip(l: List[String], start: Int, end: Int, n: Int): String = {
        val skip = for (step <- Range(start, end, n)) 
            yield l(step)
        skip.mkString(" ")
    }




    //---------------------------------------------- P U B L I C ----------------------------------------------------


    def setBuilding(row: Int, col: Int, Building: Building): Field =
        copy(cells.updated(row, cells(row).updated(col, Building)))

    def getBuilding(x: Int, y: Int): Building = cells(x)(y)
}
