package dud.model

trait Building:
    def toString(): String
    val white = "\u001b[0m"


trait House extends Building:
    def toString(): String


// -------------------------------------------- Factory für Building ---------------------------------------------------


private class Strasse1() extends Building:
    override def toString: String = "+---------+\n" + "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n"

private class Strasse2() extends Building:
    override def toString: String = "+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

private class Strasse3() extends Building:
    override def toString: String = "+--| ¦ |--+\n" + "|  | ¦ |o |\n" + "|  | ¦ || |\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

private class Haus1(color: String) extends House:
    override def toString: String = "+---------+\n" + "|    " + color + ",^¦" + white  + "  |\n"+ "|   " + color +
      "/# #\\" + white  + " |\n" + "|   " + color + "|# 1|" + white  + " |\n" + "+---------+\n"

private class Haus2(color: String) extends House:
    override def toString: String = "+---------+\n" + "|   " + color + "__" + white  + "    |\n" + "|  " + color +
      "/#  \\" + white  + "  |\n" + "|  " + color + "|2 ¦|" + white  + "  |\n" + "+---------+\n" + white

private class Haus3(color: String) extends House:
    override def toString: String = "+---------+\n" + "| " + color + "___" + white  + "     |\n" + "| " + color +
      "|# \\_" + white  + "   |\n" +"| " + color + "|# 3 |" + white  + "  |\n" + "+---------+\n" + white

private class Haus4(color: String) extends House:
    override def toString: String = "+---------+\n" + "|     " + color + "~°" + white  + "  |\n" + "|  " + color +
      ",--|¦." + white  + " |\n" + "|  " + color + "|# 4 |" + white  + " |\n" + "+---------+\n" + white

private class Empty() extends Building:
    override def toString: String = "+---------+\n" + "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n"


/*
private class ERROR(color: String) extends Building:
    override def toString: String = color + " E R R O R "+ white + "\n" + color + " Kein Feld " + white  + "\n" + color +
      " gefunden  " + white  + "\n" + color + "zurück  mit" + white  + "\n" + color + "  >> y <<  " + white + "\n"

private class NOSUCHBUILDING(color: String) extends Building:
    override def toString: String = color + "   Kein   "+ white + "\n" + color + "  solches  " + white  + "\n" + color +
      "  Gebäude  " + white  + "\n" + color + "zurück  mit" + white  + "\n" + color + "  >> y <<  " + white + "\n"
*/


object Building {
    def apply(name: String) = name match {
        case "S1" => new Strasse1()
        case "S2" => new Strasse2()
        case "S3" => new Strasse3()
        case "H1" => new Haus1("\u001b[33m")
        case "H2" => new Haus2("\u001b[32m")
        case "H3" => new Haus3("\u001b[31m")
        case "H4" => new Haus4("\u001b[36m")
        case "Empty" => new Empty()

        /*
        case "ERROR" => new ERROR("\u001b[31m")
        case _ => new NOSUCHBUILDING("\u001b[31m")
        */
    }
}

// -----------------------------------------------------------------------------------------------------------------------