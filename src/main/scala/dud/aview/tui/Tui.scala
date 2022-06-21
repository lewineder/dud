package dud
package aview

import dud.controller_component.ControllerInterface

import scala.util.Random
import dud.model.game_component.BaseIplt.{Building}
import dud.model.move_component.BaseIplt.Move
import dud.util.*
import model.*

import scala.util.{Failure, Success, Try}
import scala.io.StdIn.readLine



class Tui(controller: ControllerInterface) extends Observer{
    controller.add(this)
    def run =
        controller.handle(InitNew())
        println(controller.toString)
        getInputAndPrintLoop()

    def getInputAndPrintLoop(): Unit =
        controller.handle(Play())
        getInputLine(readLine) match
            case None =>
            case Some(move) => controller.doAndPublish(controller.setBuilding, List(move))
        getInputAndPrintLoop()


    //-----------------------------------------Option für some/none --------------------------------------------------

    //private
    def toMove(input: String): Try[Move] = Try {
        val split = input.split(" ")
        val name = split(2)
        val building = Building(name)
        Move(split(0).toInt - 1,split(1).toInt - 1, building)
    }

    def getInputLine(input: String): Option[Move] =
        input(0) match
            case 'q' => scala.sys.exit()
            case 'z' => controller.doAndPublish(controller.redo); None
            case 'y' => controller.doAndPublish(controller.undo); None
            case _ =>
                toMove(input) match {
                    case Success(m) => Some(m)
                    case Failure(n) => println(s"Falsche Eingabe: $n"); None
                }

    override def update: Unit = println(controller.toString)
}