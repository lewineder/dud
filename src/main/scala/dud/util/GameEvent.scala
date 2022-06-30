package dud
package util

//----------------------------------------------  State Pattern für Turn ---------------------------------------------

trait GameEvent

case class Play() extends GameEvent
case class InitNew() extends GameEvent
case class Interrupt() extends GameEvent
case class End() extends GameEvent

// --------------------------------------------------------------------------------------------------------------------