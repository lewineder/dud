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


@main def run(sx: Int = 6, sy: Int = 6): Unit =

    val injector = Guice.createInjector(new DrunterUndDrueberModule)
    val controller = injector.getInstance(classOf[ControllerInterface])

    //val startBuilding = 1
    //val field = new Field(sx,sy,Building("Empty"))
    //field.init
    //val player = Array(Player("1", startBuilding), Player("2", startBuilding), Player("3", startBuilding), Player("4", startBuilding))
    //val turn = Turn(0)
    //val game = Game(field, player, turn)


    val gui = new Gui(controller)
    gui.repaint()
    val tui = Tui(controller)
    tui.run


