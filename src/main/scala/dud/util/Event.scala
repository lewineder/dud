package dud.util

//----------------------------------------------  State Pattern für Turn ---------------------------------------------

trait Event

case class ResumeGame() extends Event
case class StartGame() extends Event
case class InterruptGame() extends Event
case class EndGame() extends Event

case class LoseGame() extends Event
case class WinGame() extends Event

// --------------------------------------------------------------------------------------------------------------------