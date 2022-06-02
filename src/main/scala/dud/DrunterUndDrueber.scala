package dud
import dud.aview.Tui
import dud.aview.gui.Gui
import dud.model.{Building, Field, Game, Player, Turn}
import dud.controller.Controller

import scala.io.StdIn.readLine


@main def run(sx: Int = 6, sy: Int = 6): Unit =
    /*
    println("> Willkommen zu drunter und drüber!")
    println("Spielernamen Spieler 1 eingeben: ")
        val player1 = scala.io.StdIn.readLine()
    println("Spielernamen Spieler 2 eingeben: ")
        val player2 = scala.io.StdIn.readLine()
    println("Spielernamen Spieler 3 eingeben: ")
        val player3 = scala.io.StdIn.readLine()
    println("Spielernamen Spieler 4 eingeben: ")
        val player4 = scala.io.StdIn.readLine()
    */
    val startBuilding = 1
    val field = new Field(sx,sy,Building("Empty"))
    field.init
    val player = Array(Player("1", startBuilding), Player("2", startBuilding), Player("3", startBuilding), Player("4", startBuilding))
    val turn = Turn(0)
    val game = Game(field, player, turn)
    val controller = Controller(game)
    val gui = new Gui(controller)
    gui.repaint()
    val tui = Tui(controller)
    tui.run
    


