@main
def field(arg1: Int  = 4, arg2: Int = 4, arg3: Int = 6, arg4: Int = 3): Unit =
  println("Entry")
  println(cells(arg1, arg2, arg3, arg4))

val eol: String = sys.props("line.separator")

def gencell(cellw: Int = 4, cellh: Int = 2, cellsx: Int = 3): String =
  ((" +" + ("-" * cellw) + "+") * cellsx + eol) +
    ((" |" + (" " * cellw) + "|") * cellsx + eol) * cellh +
    ((" +" + ("-" * cellw) + "+") * cellsx)

def cells(cellsx: Int = 8, cellsy: Int = 5, cellw: Int = 5, cellh: Int = 2): String =
  (gencell(cellw, cellh, cellsx) + eol) * cellsy