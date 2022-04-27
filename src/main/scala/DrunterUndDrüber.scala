import scala.io.StdIn.readLine
import model.Model
import view.Tui
import observable.Controller

object DrunterUndDrüber {

  @main
  def main(): Unit = {

    println("> Willkommen zu drunter und drüber")

    val playerArray = Array.ofDim[String](playerCount)
    println("\n> Name Spieler 1 eingeben:")
    playerArray(0) = scala.io.StdIn.readLine()
    println("> Name Spieler 2 eingeben:")
    playerArray(1) = scala.io.StdIn.readLine()
    println("> Name Spieler 3 eingeben:")
    playerArray(2) = scala.io.StdIn.readLine()
    println("> Name Spieler 4 eingeben:")
    playerArray(3) = scala.io.StdIn.readLine()
    println("\n\n")


    for ((a,i) <- playerArray.view.zipWithIndex)
      println("\n> Haus von " + a +  " platzieren (x und y Koordinate)")
      println("\n> X - Koordinate")
      val x = scala.io.StdIn.readInt()
      println("> Y - Koordinate")
      val y = scala.io.StdIn.readInt()
      Controller.set(x, y, i + 1)
    println("\n\n\n")

    do {
      for (i <- playerArray.indices)
        println("> Strasse auswählen ")
      val s = scala.io.StdIn.readInt()
      println("> X - Koordinate")
      val x = scala.io.StdIn.readInt()
      println("> Y - Koordinate")
      val y = scala.io.StdIn.readInt()
      
      Tui.TURNS(i, x, y, s, playerArray)
    } while (s != exit)
  }
}
