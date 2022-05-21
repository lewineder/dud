package dud

import dud.model.{Field, Game, Building, Turn, Player}
import dud.controller.Controller
import dud.aview.Tui
import scala.io.StdIn.readLine


@main def run(sx: Int = 6, sy: Int = 6): Unit =
    println("> Willkommen zu drunter und drüber!")
    val field = new Field(sx,sy,Building("Empty"))
    println("Spielernamen Spieler 1 eingeben: ")
        val player1 = scala.io.StdIn.readLine()
    println("Spielernamen Spieler 2 eingeben: ")
        val player2 = scala.io.StdIn.readLine()
    println("Spielernamen Spieler 3 eingeben: ")
        val player3 = scala.io.StdIn.readLine()
    println("Spielernamen Spieler 4 eingeben: ")
        val player4 = scala.io.StdIn.readLine()
    val player = Array(Player(player1, 0), Player(player2, 0), Player(player3, 0), Player(player4, 0))




    val turn = Turn(0)
    val game = Game(field, player, turn)
    val controller = Controller(game)
    val tui = Tui(controller)
    tui.run
