def tuiStartUpMenu(): Array[String] =
    println("> Willkommen zu drunter und drüber")
    val playerCount = tuiGetPLayerCount()
    getPLayerNames(playerCount)

def tuiGetPLayerCount(): Int =
    println("> Bitte Anzahl Spieler von 3-5 eintippen")
    scala.io.StdIn.readInt()

def getPLayerNames(playerCount: Int): Array[String] =
    val spielerArray = Array.ofDim[String](playerCount)
    println("> Name Speiler 1 eingeben:")
    spielerArray(0) = scala.io.StdIn.readLine()
    println("> Name Speiler 2 eingeben:")
    spielerArray(1) = scala.io.StdIn.readLine()
    println("> Name Speiler 3 eingeben:")
    spielerArray(2) = scala.io.StdIn.readLine()

    spielerArray.length match {
        case 4 =>
            println("> Name Speiler 4 eingeben:")
            spielerArray(3) = scala.io.StdIn.readLine()
        case 5 =>
            println("> Name Speiler 4 eingeben:")
            spielerArray(3) = scala.io.StdIn.readLine()
            println("> Name Speiler 5 eingeben:")
            spielerArray(4) = scala.io.StdIn.readLine()
        case _ =>
    }

    println("\n\n\n")

    return spielerArray