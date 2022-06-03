package dud.model.game_component.BaseIplt

case class Player(val name: String, var remaining: Int):

  override def minRemainig = copy(name, remaining - 1)

  override def getRemaining: Int = remaining

  override def toString = "[" + remaining + "] Gebäude verbleibend für Spieler << " + name + " >>"
