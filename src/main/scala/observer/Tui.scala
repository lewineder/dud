import scala.io.StdIn.readLine
import observable.Controller
import model.Model
import util.Observer


class Tui(controller: Controller) extends Observer{
    controller.add(this)
    def TURNS(i: Int, x: String, y: String, z: String, names: Array[String]): Int =

    println(Controller.toString)
    ("                                  " +
      "Spieler 1: " +
      names(0) +
      "   " +
      "Spieler 2: " +
      names(1) +
      "   " +
      "Spieler 3: " +
      names(2) +
      "   " +
      "Spieler 4: " +
      names(3) +
      eol +
      eol +
      "                                                         " +
      "##>  AM ZUG:  " +
      names(i) +
      "  <##") +
      eol +
      eol

    Controller.set(x, y, z)
}
