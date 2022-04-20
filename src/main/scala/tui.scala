def tuiStartUpMenu(): Array[String] =
    println("> Willkommen zu drunter und drüber")
    return getPLayerNames(4)


def getPLayerNames(playerCount: Int): Array[String] =
    val spielerArray = Array.ofDim[String](playerCount)
    println("> Name Spieler 1 eingeben:")
    spielerArray(0) = scala.io.StdIn.readLine()
    println("> Name Spieler 2 eingeben:")
    spielerArray(1) = scala.io.StdIn.readLine()
    println("> Name Spieler 3 eingeben:")
    spielerArray(2) = scala.io.StdIn.readLine()
    println("> Name Spieler 4 eingeben:")
    spielerArray(3) = scala.io.StdIn.readLine()
    println("\n\n\n")

    return spielerArray

def printPlayerNames(playerNames: Array[String], turn: Int): String =
    ("                                  " +
    "Spieler 1: " +
    playerNames(0) +
    "   " +
    "Spieler 2: " +
    playerNames(1) +
    "   " +
    "Spieler 3: " +
    playerNames(2) +
    "   " +
    "Spieler 4: " +
    playerNames(3) +
    eol +
    eol +
    "                                                         " +
    "##>  AM ZUG:  " +
    playerNames(turn) +
    "  <##") +
    eol +
    eol

def placeHouses(playerNames: Array[String], matrix: Array[Array[Int]]): Array[Array[Int]] =
    var m = matrix
    for ((a,i) <- playerNames.view.zipWithIndex)
        println(placeHouseMssg(a))
        println("> X - Koordinate")
        val x = scala.io.StdIn.readInt()
        println("> Y - Koordinate")
        val y = scala.io.StdIn.readInt()
        m = passNewStateToField(m, x, y, i + 1)

    return m



def placeHouseMssg(s: String): String =
    ("\n> Haus von " + s +  " platzieren (x und y Koordinate)")



def TURNS(playerNames: Array[String], matrix: Array[Array[Int]]): Int =

    println(
        readyStringsFromArray(
            readyStringsFromMatrix(
                genStringsFromMatrix(matrix))))

    var m = placeHouses(playerNames, matrix)

    println(
        readyStringsFromArray(
            readyStringsFromMatrix(
                genStringsFromMatrix(matrix))))

    while(true)
        for (i <- playerNames.indices)
            println("> Strasse auswählen ")
            val s = scala.io.StdIn.readInt()
            println("> X - Koordinate")
            val x = scala.io.StdIn.readInt()
            println("> Y - Koordinate")
            val y = scala.io.StdIn.readInt()
            m = passNewStateToField(m, x, y, s)
            println(
                readyStringsFromArray(
                    readyStringsFromMatrix(
                        genStringsFromMatrix(matrix))))
            println(printPlayerNames(playerNames, i))

    return 1