import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*

class mainSpec extends AnyWordSpec {
  "main" should {
    "Have a main 'field' with a Unit-return" in {
      field(1, 1, 5, 2) should be (())

    }
    /**
    "have a Greeting-Message-String of form 'Drunter und Drüber'" +
      "and have a method field creating a String of form\n" +
      "+-----+\n|     |\n|     |\n+-----+" in {
      field(1, 1, 5, 2) should be
        ("Drunter und Drüber" + eol +
          " +-----+" + eol + " |     |" + eol + " |     |" + eol + " +-----+" + eol)
    */
    "have a value Line-Seperator eol" in {
      eol should be (sys.props("line.separator"))
    }

    "have a scalable field in x and y-Direction" in {
      genCellsY(1, 1, 1, 1) should be (" +-+" + eol + " | |" + eol + " +-+" + eol)
      genCellsY(2, 2, 2, 2) should be
        (" +--+ +--+" + eol + " |  | |  |" + eol + " |  | |  |" + eol + " +--+ +--+" + eol +
        " +--+ +--+" + eol + " |  | |  |" + eol + " |  | |  |" + eol + " +--+ +--+" + eol)
    }
    "have a scalable row of scalable Cells like " +
    "+-----+ +-----+\n|     | |     |\n|     | |     |\n+-----+ +-----+" in {
      genCellsX(1, 1, 1) should be (" +-+" + eol + " | |" + eol + " +-+" + eol)
      genCellsX(2, 2, 2) should be
        (" +--+ +--+" + eol + " |  | |  |" + eol + " |  | |  |" + eol + " +--+ +--+" + eol)

    }
    "have a scalable Tops '+-+'" in {
      genCellTop(0) should be(" ++")
      genCellTop(1) should be(" +-+")
      genCellTop(2) should be(" +--+")
    }
    "have scalable Walls '|'" in {
      genCellBody(0) should be(" ||")
      genCellBody(1) should be(" | |")
      genCellBody(2) should be(" |  |")
    }
    "have a scalable Bottom" in {
      genCellBottom(0) should be(" ++")
      genCellBottom(1) should be(" +-+")
      genCellBottom(2) should be(" +--+")
    }
  }
}