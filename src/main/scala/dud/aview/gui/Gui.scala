package dud
package aview
package gui

import controller.*
import util.Event
import util.Observer
import dud.model.*

import scala.swing.*
//import scala.swing.BorderPanel.Position.*
import event.*
import java.awt.{ Color, Graphics2D }
import scala.util.Random
import scala.swing.Swing.LineBorder
import java.awt.Dimension
import java.net.http.HttpClient.Builder
import javax.swing.text.JTextComponent
import javax.swing.JTextArea
import java.awt.ComponentOrientation

class Gui(controller: Controller) extends Frame with Observer {

  controller.add(this)

  title = "Willkommen zu drunter und drüber"
  preferredSize = new Dimension(controller.game.field.col * 80,controller.game.field.row * 80)
  val field = controller.game.field
  contents = new BorderPanel {
    add(box, BorderPanel.Position.North)
    add(new Draw(field.col - 1,field.row - 1), BorderPanel.Position.Center)
    add(turnLabel, BorderPanel.Position.South)
  }

  menuBar = new MenuBar {
    contents += new Menu("Menu") {
      contents += new MenuItem(Action("Quit") {
        closeNow() })
      contents += new MenuItem(Action("New Game") {
        newGame()
      })
      }
  }
  
  def newGame(): Unit = {
    val r = Dialog.showInput(contents.head, "Spielfeldgröße: ", initial="10 10")
    val p1 = Dialog.showInput(contents.head, "Spieler1", initial="Name")
    val p2 = Dialog.showInput(contents.head, "Spieler2", initial="Name")
    val p3 = Dialog.showInput(contents.head, "Spieler3", initial="Name")
    val p4 = Dialog.showInput(contents.head, "Spieler4", initial="Name")

    r match {
      case Some(s) =>
      case None => 
    }
  }

  def closeNow(): Unit = {
    val res = Dialog.showConfirmation(contents.head, 
      "Do you really want to quit?", 
      optionType=Dialog.Options.YesNo,
      title=title)
    if (res == Dialog.Result.Ok)
      sys.exit(0)
  }

  def box = new FlowPanel{
    contents += new Button(Action("Undo") {controller.doAndPublish(controller.redo)})
    contents += new Button(Action("Redo") {controller.doAndPublish(controller.undo)})   }

  visible = true
  pack()
  centerOnScreen()
  open()

  class Draw(x: Int, y: Int) extends GridPanel(x + 1, y + 1):
      for (i <- 0 to x) {
        for (j <- 0 to y) {
          val building = controller.game.field.getBuilding(i,j)
          val b = new CellButton(i,j,building.map)
          if (building.name == "Empty")
            b.background = Color.white
          else if (building.isInstanceOf[House])
            b.background = building.asInstanceOf[House].colorM
          else {b.background = Color.gray}
          contents += b
          
        }
      }    

  class CellButton(x: Int, y: Int, building: String) extends Button(building):
      listenTo(mouse.clicks)
      reactions += {
        case MouseClicked(src, pt, mod, clicks, props) => {
          val r = Dialog.showInput(contents.head, "Strasse", initial="S1")
          r match {
            case Some(r) => controller.doAndPublish(controller.setBuilding, Move(x,y,Building(r)))
            case None => 
          }
        }
        case KeyTyped(_,c,_,_) =>
          c match {
            case '1' => controller.doAndPublish(controller.setBuilding, Move(x,y,Building("S1")))
            case '2' => controller.doAndPublish(controller.setBuilding, Move(x,y,Building("S2")))
            case '3' => controller.doAndPublish(controller.setBuilding, Move(x,y,Building("S3")))
          }
        }
      
  def turnLabel = new GridPanel(4, 1) {
    for (i <- controller.game.players)
      contents += new Label(i.toString)
  }
/*
  override def update(e: util.Event): Unit = { e match
    case Event.FieldChanged => repaint()//new Gui(controller)repaint()
  }
*/
  var a = 0
  override def update: Unit = {
    contents = new BorderPanel {
    add(box, BorderPanel.Position.North)
    add(new Draw(field.col - 1,field.row - 1), BorderPanel.Position.Center)
    add(turnLabel, BorderPanel.Position.South)
    repaint()
  }
}
}