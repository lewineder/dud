@main 
def fieldUser(cellsx: Int  = 4, cellsy: Int = 4, cellw: Int = 6, cellh: Int = 3): Unit =
  println("Entry")
  println(cells(cellsx, cellsy, cellw, cellh))
  println("new ")

@main
def field(): Unit =
  println("Entry")
  println(cells(8,5,5,2))

val eol = sys.props("line.separator")
val sep = "    "

def genscrollent(cellw: Int = 4, cellh: Int = 2, cellsx: Int = 3) =
  val con = cellw*cellsx + cellsx *3
  (sep +  ("_" * (con + 8)) + eol +
  (" / \\ " + sep + sep + " " * con + "\\." + eol) +
  ("|   |" + sep + sep + (" " * con) + "|." + eol) +
  (" \\_ |" + sep + sep + (" " * con) + "|." + eol))


def genscrollend(cellw: Int, cellsx: Int) = 
  val con = cellw*cellsx + cellsx *3
  (sep + "|" + "   " + ("_" * con) + "_____|___" + eol) +
  ( sep + "|" + "  /" + (" " * con) + "        /" + eol) +
  ( sep + "\\" + "_/_" + ("_" * con) + "_______/ " + eol) 

def gencell(cellw: Int = 4, cellh: Int = 2, cellsx: Int = 3) =
  (sep + "|" + sep + ( " +" + ("-" * cellw) + "+") * cellsx + sep + "|. " + eol) +
  (sep + "|" + sep + ( " |" + (" " * cellw) + "|") * cellsx + sep + "|. " + eol) * cellh +
  (sep + "|" + sep + ( " +" + ("-" * cellw) + "+") * cellsx + sep + "|. " )

def cells(cellsx: Int = 8, cellsy: Int = 5, cellw: Int = 5, cellh: Int = 2) =
  genscrollent(cellw, cellh, cellsx) +
  (gencell(cellw, cellh, cellsx) + eol) * cellsy +
  genscrollend(cellw, cellsx)

