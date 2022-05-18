package dud
package aview

import controller.Controller
import dud.util.{ResumeGame, StartGame, Observer}
import model.{Building, Field, Move, Turn}

import scala.io.StdIn.readLine



class Tui(controller: Controller) extends Observer{
    controller.add(this)
    def run =
        controller.handle(StartGame()) //todo: COntroler-Handles funktionieren noch nicht - sind irgendwiw NULL obowhl Option
        println(controller.toString)
        getInputAndPrintLoop()

    def getInputAndPrintLoop(): Unit =

        getInputLine(readLine) match
            case None =>
            case Some(move) => controller.doAndPublish(controller.setBuilding, move)
        controller.handle(ResumeGame())  //todo: Noch mal Cotnroller-Handle
        getInputAndPrintLoop()

    //-----------------------------------------Option für some/none --------------------------------------------------

    def getInputLine(input: String): Option[Move] =
        input(0) match
            case 'q' => scala.sys.exit()
            case 'z' => controller.doAndPublish(controller.redo); None
            case 'y' => controller.doAndPublish(controller.undo); None
            case _ =>
                val split = input.split(" ")
                val name = split(2)
                val building = Building(name)
                Some(Move(split(0).toInt - 1,split(1).toInt - 1, building))


    //----------------------------------------------------------------------------------------------------------------

    override def update: Unit = println(controller.toString)
}
