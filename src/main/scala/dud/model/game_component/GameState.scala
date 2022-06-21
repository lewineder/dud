package dud
package model.game_component

import model.game_component.BaseIplt.Turn
import util.GameEvent


//------------------------------------------- Factory für State ------------------------------------------------------


            //-------------------- Option für some/none in State + GameEvent ---------------------

trait Stateable:

  var gamestate: Option[GameState] = None //Status zum mitgeben
  def handle(e: GameEvent): Option[GameState] //handle für TUI

            //---------------------------------------------------------------------------------


trait GameState:
  def toString(): String

case class Playing(turn: Turn) extends GameState :
  override def toString = "Spieler " + turn.turnsPlayed + " Nächste Strasse setzen"

case class Interrupted(turn: Turn) extends GameState :
  override def toString = "Fehler beim setzen - zurück mit >> y <<"

case class Finished(turn: Turn) extends GameState:
  override def toString = "✧･ﾟ: *✧･ﾟ:* 　Glückwunsch!!! End of Game　 *:･ﾟ✧*:･ﾟ✧"

case class Starting(turn: Turn) extends GameState:
  override def toString = "Spiel startet Spieler 1 bitte erste Strasse am Spielfeldrand setzen"