package dud
package util

//----------------------------------------------  State Pattern für Turn ---------------------------------------------

trait GameEvent

case class P1next() extends GameEvent
case class P2next() extends GameEvent
case class P3next() extends GameEvent
case class P4next() extends GameEvent

case class InitNew() extends GameEvent
case class Interrupt() extends GameEvent
case class End() extends GameEvent

// --------------------------------------------------------------------------------------------------------------------