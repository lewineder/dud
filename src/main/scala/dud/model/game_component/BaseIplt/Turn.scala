package dud
package model.game_component.BaseIplt

import model.game_component.{Playing, Starting, Finished, Interrupted,Stateable}
import model.game_component.GameState
import util.*
import util.GameEvent

import com.google.inject.Inject

case class Turn(var turnsPlayed: Int) extends Stateable :

  //---------------------------------------------- Strategy von State-Event --------------------------------------------
  override def handle(event: GameEvent): Option[GameState] =
    event match {
      case init: InitNew => gamestate = Some(Starting(this))
      case play: Play => gamestate = Some(Playing(this))
      case stop: Interrupt => gamestate = Some(Interrupted(this))
      case fin: End => gamestate = Some(Finished(this))
    }
    gamestate

  def setTurn(skip: Int): Turn = 
    val numOfPlayers = 4
    turnsPlayed = (turnsPlayed + skip) % numOfPlayers + 1
    this

  override def toString(): String = {
    gamestate.get.toString()
  }