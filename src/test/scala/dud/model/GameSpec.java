package dud.model;

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

public class GameSpec extends AnyWordSpec {
    "A game " when {

        field1 = new Field(1, 1, Building("Empty"))
        val player = Array(Player("Farin", 1), Player("Rod", 1), Player("Bela", 1), Player("Herbert", 1))
        val turn = new Turn(0)
        game = Game(field1, player, turn)
        "filled with" should {
            "be able to call a handle" in {
                handle(event: Event)
            }
        }

}

    def handle(event: Event): Option[GameState] =
            turn.handle(event)

    private def playersToString: String =
    val con = for (p <- players) yield p.toString
    con.mkString("\n")



    def setBuilding(row: Int, col: Int, building: Building) : Game =
    copy(field.setBuilding(row, col, building), players, turn)



    override def toString =
    field.toString + "\n" + playersToString + "\n" + turn.toString
}
