package dud

import dud.model.{Field, Player, Building}
import dud.controller.Controller
import dud.aview.Tui

@main def run(sx: Int, sy: Int): Unit = 
    println("> Willkommen zu drunter und drüber!")
    val field = new Field(sx,sy,Building.Empty)
    val controller = Controller(field)
    val tui = Tui(controller)
    tui.run
