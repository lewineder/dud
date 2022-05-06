package dud
package aview

import controller.Controller
import model.{Field, Building, Move}
import scala.io.StdIn.readLine
import util.Observer


class Tui(controller: Controller) extends Observer{
    controller.add(this)
    def run = 
        println(controller.playingField.toString)
        getInputAndPrintLoop()

    def getInputAndPrintLoop(): Unit =
        getInputLine(readLine) match
            case None =>
            case Some(move) => controller.doAndPublish(controller.setBuilding, move)
        getInputAndPrintLoop()

    
    def getInputLine(input: String): Option[Move] =
        input(0) match
            case 'q' => None
            case _ => {
                val x = input(0).toString.toInt
                val y = input(1).toString.toInt
                val b = input(3).toString + input(4).toString
                val building = b match
                    case "S1" => Building.S1
                    case "S2" => Building.S2
                    case "S3" => Building.S3
                    case "H1" => Building.H1
                    case "H2" => Building.H2
                    case "H3" => Building.H3
                    case "H4" => Building.H4
                Some(Move(x,y,building))
            }

    override def update: Unit = println(controller.playingField.toString)
}
