package dud

import dud.model.{Field, Building, Turn, Player}
import dud.controller.Controller
import dud.aview.Tui

@main def run(sx: Int = 6, sy: Int = 6): Unit =
    println("> Willkommen zu drunter und drüber!")
    val field = new Field(sx,sy,Building("Empty"))
    val turn = Turn(Array.ofDim[Player](4), 0) //todo: Könnte Spielerzahl noch dynamisch machen
    val controller = Controller(field, turn)
    val tui = Tui(controller)
    tui.run
