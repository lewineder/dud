package dud.model

case class Player(name: String, remaining: Int):
  override def toString = "[" + remaining + "] Gebäude verbleibend für Spieler << " + name + " >>"