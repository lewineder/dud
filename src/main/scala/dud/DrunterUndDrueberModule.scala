package dud

import com.google.inject.AbstractModule
import controller_component.ControllerInterface
import controller_component.BaseIplt.Controller
import model.game_component.GameInterface
import model.game_component.BaseIplt.Game


import com.google.inject.name.Names


class DrunterUndDrueberModule extends AbstractModule{
  override def configure(): Unit =
    bind(classOf[ControllerInterface]).to(classOf[Controller])
    bind(classOf[GameInterface]).to(classOf[Game])
}