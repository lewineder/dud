package dud.util

//----------------------------------------------  State Pattern für Turn ---------------------------------------------

trait Event

case class P1next() extends Event
case class P2next() extends Event
case class P3next() extends Event
case class P4next() extends Event

case class InitNew() extends Event
case class Interrupt() extends Event
case class End() extends Event

// --------------------------------------------------------------------------------------------------------------------