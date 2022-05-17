package dud.model

case class Move(row: Int, col: Int, building: Building)

object SaveMove {
  def apply(move: Move, field: Array[Array[Building]]): Move = {
    if (move.row < 1) || (move.col < 1) || (move.row > field.length - 1) || (move.col > field(0).length - 1) then
      Move(field.length / 2, field(0).length / 2, Building("ERROR"))
    else move
  }
}