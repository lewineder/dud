package dud.model

trait Building:
    def toString(): String


private class Strasse1() extends Building:
    override def toString: String = "+---------+\n" + "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n"

private class Strasse2() extends Building:
    override def toString: String = "+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

private class Strasse3() extends Building:
    override def toString: String = "+--| ¦ |--+\n" + "|  | ¦ |o |\n" + "|  | ¦ || |\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

private class Haus1(color: String) extends Building:
    override def toString: String = "+---------+\n" + "|    " + color + ",^¦" + "\u001b[0m"  + "  |\n"+ "|   " + color +
      "/# #\\" + "\u001b[0m"  + " |\n" + "|   " + color + "|# 1|" + "\u001b[0m"  + " |\n" + "+---------+\n"

private class Haus2(color: String) extends Building:
    override def toString: String = "+---------+\n" + "|   " + color + "__" + "\u001b[0m"  + "    |\n" + "|  " + color +
      "/#  \\" + "\u001b[0m"  + "  |\n" + "|  " + color + "|2 ¦|" + "\u001b[0m"  + "  |\n" + "+---------+\n" + "\u001b[0m"

private class Haus3(color: String) extends Building:
    override def toString: String = "+---------+\n" + "| " + color + "___" + "\u001b[0m"  + "     |\n" + "| " + color +
      "|# \\_" + "\u001b[0m"  + "   |\n" +"| " + color + "|# 3 |" + "\u001b[0m"  + "  |\n" + "+---------+\n" + "\u001b[0m"

private class Haus4(color: String) extends Building:
    override def toString: String = "+---------+\n" + "|     " + color + "~°" + "\u001b[0m"  + "  |\n" + "|  " + color +
      ",--|¦." + "\u001b[0m"  + " |\n" + "|  " + color + "|# 4 |" + "\u001b[0m"  + " |\n" + "+---------+\n" + "\u001b[0m"

private class Empty() extends Building:
    override def toString: String = "+---------+\n" + "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n"


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
    }
}