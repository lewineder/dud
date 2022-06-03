package dud.model
package game_component.BaseIplt

import dud.model.game_component.GameState
import dud.model.game_component.{Finished, Interrupted, Player1, Player2, Player3, Player4, Starting, Stateable}
import dud.util.GameEvent


case class Turn(turnsPlayed: Int) extends Stateable :

  //---------------------------------------------- Strategy von State-Event --------------------------------------------
  override def handle(event: GameEvent): Option[GameState] =
    event match {
      case init: InitNew => gamestate = Some(Starting(this))

      case p1: P1next => gamestate = Some(Player1(this))
      case p2: P2next => gamestate = Some(Player2(this))
      case p3: P3next => gamestate = Some(Player3(this))
      case p4: P4next => gamestate = Some(Player4(this))

      case stop: Interrupt => gamestate = Some(Interrupted(this))
      case fin: End => gamestate = Some(Finished(this))
    }
    gamestate

  // -------------------------------------------------------------------------------------------------------------------

  override def toString(): String = {
    gamestate.get.toString()
  }
