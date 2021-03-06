package dud.model.game_component.BaseIplt

import dud.model.*

import java.awt.Color

trait Building:
    def map: String
    def name: String
    def toString: String
    val white = "\u001b[0m"


trait House extends Building:
    def colorM: Color
    def name: String
    def toString: String


// -------------------------------------------- Factory für Building ---------------------------------------------------


class Strasse1() extends Building:
    override def map: String = "/image2b.png"
    override def name: String = "S1"
    override def toString: String = "+---------+\n" + "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n"

class Strasse2() extends Building:
    override def map: String = "/image1.png"
    override def name: String = "S2"
    override def toString: String = "+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

class Strasse4() extends Building:
    override def map: String = "/image3a.png"
    override def name: String = "S4"
    override def toString: String = "+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

class Strasse5() extends Building:
    override def map: String = "/image3b.png"
    override def name: String = "S5"
    override def toString: String = "+--| ¦ |--+\n" + "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

class Strasse3() extends Building:
    override def map: String = "/image2a.png"
    override def name: String = "S3"
    override def toString: String = "+--| ¦ |--+\n" + "|  | ¦ |o |\n" + "|  | ¦ || |\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n"

class Haus1(color: String) extends House:
    override def map: String = "/house1.png"
    def colorM: Color = Color.red
    override def name: String = "H1"
    override def toString: String = "+---------+\n" + "|    " + color + ",^¦" + white  + "  |\n"+ "|   " + color +
      "/# #\\" + white  + " |\n" + "|   " + color + "|# 1|" + white  + " |\n" + "+---------+\n"

class Haus2(color: String) extends House:
    override def map: String = "/house4.png"
    def colorM: Color = Color.blue
    override def name: String = "H2"
    override def toString: String = "+---------+\n" + "|   " + color + "__" + white  + "    |\n" + "|  " + color +
      "/#  \\" + white  + "  |\n" + "|  " + color + "|2 ¦|" + white  + "  |\n" + "+---------+\n" + white

class Haus3(color: String) extends House:
    override def map: String = "/house2.png"
    def colorM: Color = Color.green
    override def name: String = "H3"
    override def toString: String = "+---------+\n" + "| " + color + "___" + white  + "     |\n" + "| " + color +
      "|# \\_" + white  + "   |\n" +"| " + color + "|# 3 |" + white  + "  |\n" + "+---------+\n" + white

class Haus4(color: String) extends House:
    override def map: String = "/house3.png"
    override def colorM: Color = Color.yellow
    override def name: String = "H4"
    override def toString: String = "+---------+\n" + "|     " + color + "~°" + white  + "  |\n" + "|  " + color +
      ",--|¦." + white  + " |\n" + "|  " + color + "|# 4 |" + white  + " |\n" + "+---------+\n" + white

class Empty() extends Building:
    override def map: String = "/empty.png"
    override def name: String = "Empty"
    override def toString: String = "+---------+\n" + "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n"


object Building {
    def apply(name: String) = name match {
        case "S1" => new Strasse1()
        case "S2" => new Strasse2()
        case "S3" => new Strasse3()
        case "S4" => new Strasse4()
        case "S5" => new Strasse5()
        case "H1" => new Haus1("\u001b[33m")
        case "H2" => new Haus2("\u001b[32m")
        case "H3" => new Haus3("\u001b[31m")
        case "H4" => new Haus4("\u001b[36m")
        case "Ey" => new Empty()
    }
}

object House {
    def apply(name: String) = name match {
        case "H1" => new Haus1("\u001b[33m")
        case "H2" => new Haus2("\u001b[32m")
        case "H3" => new Haus3("\u001b[31m")
        case "H4" => new Haus4("\u001b[36m")
       
    }
}
