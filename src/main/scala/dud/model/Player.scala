package dud.model

import scala.language.postfixOps

case class Player(val name: String, var remaining: Int):
  
  def minRemainig: Player = copy(name, remaining - 1)
  
  def getRemaining: Int = remaining
  
  override def toString = "[" + remaining + "] Gebäude verbleibend für Spieler << " + name + " >>"




/*
package dud.model

object PhantomPlayer {
  def apply (arr: Array[Array[Building]]) : Array[Array[Building]]  =
    val rd = scala.util.Random.shuffle(0.until (arr.size * arr(0).size))
    for (i <- 0 until (((arr.size * arr(0).size) / 20) * 4)) {
      arr(rd(i)/arr(0).size)(rd(i) % arr(0).size) = getBuild(i%4)
    }
    arr

  def getBuild = Array(Building.H1, Building.H2, Building.H3, Building.H4)
*/