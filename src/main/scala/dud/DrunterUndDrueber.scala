package dud
import aview.Tui
import aview.gui.Gui
import model.game_component.GameInterface
import controller_component.BaseIplt
import controller_component.ControllerInterface
import controller_component.BaseIplt.Controller
import model.game_component.BaseIplt.{Building, Field, Game, Player, Turn}

import scala.io.StdIn.readLine

import com.google.inject.Guice


@main def run: Unit =

    val injector = Guice.createInjector(new DrunterUndDrueberModule)
    

    lazy val controller:ControllerInterface = injector.getInstance(classOf[Controller])

    val gui = new Gui(controller)
    gui.repaint()
    val tui = Tui(controller)
    tui.run


