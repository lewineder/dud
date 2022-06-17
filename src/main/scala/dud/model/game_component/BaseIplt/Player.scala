package dud.model.game_component.BaseIplt
import com.google.inject.Inject

case class Player (val name: String, var remaining: Int):

  def minRemainig = copy(name, remaining - 1)

  def getRemaining: Int = remaining

  override def toString = "[" + remaining + "] Gebäude verbleibend für Spieler << " + name + " >>"
