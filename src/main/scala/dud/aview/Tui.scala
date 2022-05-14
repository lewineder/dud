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
            case 'q' => scala.sys.exit()
            case 'z' => controller.doAndPublish(controller.redo); None
            case 'y' => controller.doAndPublish(controller.undo); None
            case _ => {
                val split = input.split(" ")
                val x = split(0).toInt
                val y = split(1).toInt
                val name = split(2)
                val building = Building(name)
                Some(Move(x-1,y-1,building))
            }

    override def update: Unit = println(controller.playingField.toString)
}
