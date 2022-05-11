package dud.util

object Turns {
  trait Strategy {
    def execute
  }

  class BuildingPlacement extends Strategy {
    override def execute = println("Gebäude platzieren")
  }
  class StreetPlacement extends Strategy {
    override def execute = println("Strassen platzieren")
  }
}
