package dud.model

import dud.util.Event
import dud.model.Turn


//------------------------------------------- Factory für State ------------------------------------------------------


            //-------------------- Option für some/none in State + Event ---------------------

trait Stateable:
  var gamestate: Option[GameState] = None
  def handle(e: Event): Option[GameState]

            //---------------------------------------------------------------------------------


trait GameState:
  def toString(): String

case class Playable(turn: Turn) extends GameState :
  override def toString = "Nächste Strasse setzen"

case class Interrupted(turn: Turn) extends GameState :
  override def toString = "Problem lösen"

case class Finished(turn: Turn) extends GameState:
  override def toString = "Spiel zu ende glückwunsch"

case class Starting(turn: Turn) extends GameState:
  override def toString = "Spiel startet"

//---------------------------------------------------------------------------------------------------------------------
