@main 
def field(cellsx: Int  = 1, cellsy: Int = 1, cellw: Int = 5, cellh: Int = 2): Unit =
  println("Drunter und Drüber")
  println(genCellsY(cellsx, cellsy, cellw, cellh))

val eol: String =
  sys.props("line.separator")

def genCellsY(cellsx: Int, cellsy: Int, cellw: Int, cellh: Int): String =
  genCellsX(cellsx, cellw, cellh) * cellsy

def genCellsX(cellsx: Int,  cellw: Int, cellh: Int): String =
  genCellTop(cellw) * cellsx + eol +
  (genCellBody(cellw) * cellsx + eol) * cellh +
  genCellBottom(cellw) * cellsx + eol

def genCellTop(cellw: Int): String =
  " +" + ("-" * cellw) + "+"

def genCellBody(cellw: Int): String =
  " |" + (" " * cellw) + "|"

def genCellBottom(cellw: Int): String =
  " +" + ("-" * cellw) + "+"

