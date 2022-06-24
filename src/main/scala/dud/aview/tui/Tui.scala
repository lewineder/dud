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
            case Some(move) => controller.doAndPublish(controller.setBuilding, move)
        getInputAndPrintLoop()


    //-----------------------------------------Option für some/none --------------------------------------------------

    //private
    def toMove(input: String): Try[List[Move]] = Try {
        val split = input.split(" ")
        val x = split(0).toInt - 1
        val y = split(1).toInt - 1
        val name = split(2)
        name match
            case "1" => List(Move(x,y,Building("S2")))
            case "2t" => List(Move(x - 1,y,Building("S2")), Move(x,y,Building("S3")))
            case "2r" => List(Move(x,y,Building("S1")), Move(x,y + 1,Building("S2")))
            case "2b" => List(Move(x ,y ,Building("S3")), Move(x + 1,y,Building("S2")))
            case "2l" => List(Move(x ,y - 1,Building("S2")), Move(x ,y,Building("S1")))
            case "3b" => List(Move(x + 2 ,y,Building("S2")), Move(x + 1 ,y,Building("S4")), Move(x,y,Building("S3")))
            case "3r" => List(Move(x ,y - 2,Building("S2")), Move(x ,y,Building("S1")), Move(x ,y - 1,Building("S5")))
            case "3t" => List(Move(x - 2 ,y,Building("S2")), Move(x ,y,Building("S3")), Move(x - 1,y,Building("S4")))
            case "3l" => List(Move( x ,y + 2,Building("S2")), Move(x ,y,Building("S1")), Move(x, y + 1,Building("S5")))
        //val building = Building(name)
       // Move(split(0).toInt - 1,split(1).toInt - 1, building)
    }

    def getInputLine(input: String): Option[List[Move]] =
        input(0) match
            case 'q' => scala.sys.exit()
            case 'z' => controller.doAndPublish(controller.redo); None
            case 'y' => controller.doAndPublish(controller.undo); None
            case 'l' => controller.load; None
            case 's' => controller.save; None
            case _ =>
                toMove(input) match {
                    case Success(m) => Some(m)
                    case Failure(n) => println(s"Falsche Eingabe: $n"); None
                }

    override def update: Unit = println(controller.toString)
}