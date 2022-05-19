package dud.util


// ------------------------------------------------Undo Mechanismus --------------------------------------------------

trait Command[T]:
  def noPlacement(t: T): T
  def doPlacement(t: T): T
  def undoPlacement(t: T): T
  def redoPlacement(t: T): T

class UndoManager[T]:
  private var undoStack: List[Command[T]] = Nil
  private var redoStack: List[Command[T]] = Nil
  def doPlacement(t: T, command: Command[T]): T =
    undoStack = command :: undoStack
    command.doPlacement(t)
  def undoPlacement(t: T): T =
    undoStack match {
      case Nil => t
      case head :: stack => {
        val result = head.undoPlacement(t)
        undoStack = stack
        redoStack = head :: redoStack
        result
      }
    }
  def redoPlacement(t: T): T =
    redoStack match {
      case Nil => t
      case head :: stack => {
        val result = head.redoPlacement(t)
        redoStack = stack
        undoStack = head :: undoStack
        result
      }
    }

// --------------------------------------------------------------------------------------------------------------------


