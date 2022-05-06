package dud.aview

import dud.controller.Controller
import dud.model.{Field, Building}
import scala.io.StdIn.readLine
import dud.util.Observer


class Tui(controller: Controller) extends Observer{
    controller.add(this)
    def run = 
        println(controller.playingField.toString)
        getInputLine()

    
    def getInputLine(): Unit = {
        val input = readLine.toList
        input(0) match
            case 'q' =>
            case 'p' => {
                val player = input.tail.toString.split(" ")
                controller.setPlayer(player)
                getInputLine() }
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
                controller.setBuilding(x,y,building)
                println(controller.toString)
                getInputLine() }
    }

    override def update: Unit = println()
}
