package dud.model

import dud.util.*
import dud.model.GameState

import scala.runtime.RichInt

case class Turn(players: Array[Player], turnsPlayed: Int) extends Stateable:
  def this(p: Array[String], i: Int) = this(players = Array[Player](), turnsPlayed = i) //todo: braucht noch Arbeit hier sollten eigentlich die Player einmal upgedatet werden


  val players2: Array[Player] = Array[Player](Player("Rod", 2), Player("Farin", 1), Player("Bela", 4)) //todo: das hier wir nicht gebraucht

  //------------------------------------------------- State von Event -------------------------------------------------
  override def handle(e: Event): Option[GameState] =
    e match {
      case start: Starting => gamestate = Some(Starting(this))
      case play: Playable => gamestate = Some(Playable(this))
      case interrupt: Interrupted => gamestate = Some(Interrupted(this))
      case finish: Finished => gamestate = Some(Finished(this))
      case _ => None
    }
    gamestate

  // -------------------------------------------------------------------------------------------------------------------


  override def toString(): String = {
    /*for (state <- gamestate) yield state match {
      case Some(s) => s.toString + players2.toString
      case _ => players2.toString
    }*/

    (for (p <- players2) yield p.toString).mkString("\n")
  } //todo: braucht noch arbeit (sollte eigentlich die richtigen Player ausgeben, nicht die vals, die müssen aber von TUI und COntroller zuerst upgedatet und initialisiert
    //todo: ausserdem funktioniert die for-Schleife mit den Option-Monaden nicht)
