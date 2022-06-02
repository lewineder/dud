package dud.model

import dud.util.GameEvent
import dud.model.Turn


//------------------------------------------- Factory für State ------------------------------------------------------


            //-------------------- Option für some/none in State + GameEvent ---------------------

trait Stateable:

  var gamestate: Option[GameState] = None //Status zum mitgeben
  def handle(e: GameEvent): Option[GameState] //handle für TUI

            //---------------------------------------------------------------------------------


trait GameState:
  def toString(): String

case class Player1(turn: Turn) extends GameState :
  override def toString = "Spieler 1 Nächste Strasse setzen"

case class Player2(turn: Turn) extends GameState :
  override def toString = "Spieler 2 Nächste Strasse setzen"

case class Player3(turn: Turn) extends GameState :
  override def toString = "Spieler 3 Nächste Strasse setzen"

case class Player4(turn: Turn) extends GameState :
  override def toString = "Spieler 4 Nächste Strasse setzen"

case class Interrupted(turn: Turn) extends GameState :
  override def toString = "Fehler beim setzen - zurück mit >> y <<"

case class Finished(turn: Turn) extends GameState:
  override def toString = "Spiel zu Ende glückwunsch"

case class Starting(turn: Turn) extends GameState:
  override def toString = "Spiel startet Spieler 1 bitte erste Strasse am Spielfeldrand setzen"

//---------------------------------------------------------------------------------------------------------------------
