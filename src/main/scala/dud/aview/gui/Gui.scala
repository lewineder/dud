package dud
package aview
package gui

import controller_component.*
import controller_component.ControllerInterface
import model.*
import model.game_component.*
import model.game_component.BaseIplt.Building
import model.move_component.BaseIplt.Move
import util.{Event, Observer}

import java.lang.Math
import scala.swing.*
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File
import event.*
import java.awt.{ Color, Graphics2D }
import scala.util.Random
import scala.swing.Swing.LineBorder
import java.awt.Dimension
import java.net.http.HttpClient.Builder
import javax.swing.text.JTextComponent
import javax.swing.JTextArea
import javax.swing.JTable
import java.awt.ComponentOrientation
import javax.swing.ImageIcon
import javax.swing.BorderFactory
import javax.swing.border.*
import javax.swing.JOptionPane

class Gui(controller: ControllerInterface) extends Frame with Observer {
  controller.add(this)
  title = "Willkommen zu drunter und drüber"
  val field = controller.game.getField()
  contents = new BorderPanel {
    add(box, BorderPanel.Position.North)
    add(new Draw(field.row - 1,field.col - 1), BorderPanel.Position.Center)
    add(pictures, BorderPanel.Position.South)
    add(turnLabel, BorderPanel.Position.East)
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

  def endGame(): Unit = {
    val icon = new ImageIcon(getClass.getResource("/party.png"))
    val res = Dialog.showMessage(contents.head, "", title= "Glückwunsch!!! Spiel ist zu Ende", icon = icon )
  }

  def box = new FlowPanel {
    contents += new Button(Action("Undo") {
      controller.doAndPublish(controller.undo)
    })
    contents += new Button(Action("Redo") {
      controller.doAndPublish(controller.redo)
    })
  }
  
  visible = true
  pack()
  centerOnScreen()
  open()

  class Draw(x: Int, y: Int) extends GridPanel(x + 1, y + 1):
      for (i <- 0 to x) {
        for (j <- 0 to y) {
          val building = controller.game.getField().getBuilding(i,j)
          val b = new CellButton(i,j, building.map)
          contents += b
          
        }
      }    

  class CellButton(x: Int, y: Int, bild: String) extends Button:
    icon = new ImageIcon(getClass.getResource(bild))
    border = null
    //preferredSize = new Dimension(100,100)
    listenTo(mouse.clicks)
    reactions += {
      case MouseClicked(src, pt, mod, clicks, props) => {
          number match {
          case 1 => controller.doAndPublish(controller.setBuilding, List(Move(x,y,Building("S2"))))
          case 2 => controller.doAndPublish(controller.setBuilding, List(Move(x - 1,y,Building("S2")), Move(x,y,Building("S3"))))
          case 3 => controller.doAndPublish(controller.setBuilding, List(Move(x,y,Building("S1")), Move(x,y + 1,Building("S2"))))
          case 4 => controller.doAndPublish(controller.setBuilding, List(Move(x ,y ,Building("S3")), Move(x + 1,y,Building("S2"))))
          case 5 => controller.doAndPublish(controller.setBuilding, List(Move(x ,y - 1,Building("S2")), Move(x ,y,Building("S1"))))
          case 6 => controller.doAndPublish(controller.setBuilding, List(Move(x + 2 ,y,Building("S2")), Move(x + 1 ,y,Building("S4")), Move(x,y,Building("S3"))))
          case 7 => controller.doAndPublish(controller.setBuilding, List(Move(x ,y - 2,Building("S2")), Move(x ,y,Building("S1")), Move(x ,y - 1,Building("S5"))))
          case 8 => controller.doAndPublish(controller.setBuilding, List(Move(x - 2 ,y,Building("S2")), Move(x ,y,Building("S3")), Move(x - 1,y,Building("S4"))))
          case 9 => controller.doAndPublish(controller.setBuilding, List(Move( x ,y + 2,Building("S2")), Move(x ,y,Building("S1")), Move(x, y + 1,Building("S5"))))
          case 0 => 
        }
      }
      }

  def pictures = new FlowPanel {
    val b1 = createButton("/image1.png")
    contents += b1
    contents += createButton("/two1.png")
    contents += createButton("/three1.png")
  }

  var number = 0
  class createButton(path: String) extends Button:
    preferredSize = new Dimension(200,200)
    border = null
    icon = new ImageIcon(getClass.getResource(path))
    val list1 = List("/two1.png", "/two2.png", "/two3.png", "/two4.png")
    val list2 = List("/three1.png", "/three2.png", "/three3.png", "/three4.png")
    listenTo(mouse.clicks)
    reactions += {
      case MouseClicked(src, pt, mod, clicks, props) => {
        if (border == null)
          number = getNumber        
          border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE.darker(), Color.BLACK),BorderFactory.createEtchedBorder(EtchedBorder.LOWERED))
        else
          if (list1.contains(path))
            val next = list1(Math.floorMod(number - 1,4))
            icon = new ImageIcon(getClass.getResource(next))
            number = list1.indexOf(next) + 2
            println(number)
          if (list2.contains(path))
            val next = list2(Math.floorMod(number - 5,4))
            icon = new ImageIcon(getClass.getResource(next))
            number = list2.indexOf(next) + 6
      }
    }
    def getNumber : Int = 
      path match {
            case "/image1.png" => 1
            case "/two1.png" => 2
            case "/two2.png" => 3
            case "/two3.png" => 4
            case "/two4.png" => 5
            case "/three1.png" => 6
            case "/three2.png" => 7
            case "/three3.png" => 8
            case "/three4.png" => 9
          }
      
  
  def turnLabel = new GridPanel(4, 1) {
    for (i <- 0 until controller.game.players.length)
      val pts = controller.game.pointsToString()
      val points = new Label("    " + pts(i) + "    ")
      if (controller.game.turn.turnsPlayed == i + 1)
        points.foreground = Color.red
      contents += points
  }
  

  def createTable: Table = {
    val table = new Table(2,4)
    for (i <- 0 to 3)
      table.update(0,i, controller.game.players(i))
    table
  }

  override def update: Unit = {
    contents = new BorderPanel {
    add(box, BorderPanel.Position.North)
    add(new Draw(field.col - 1,field.row - 1), BorderPanel.Position.Center)
    //add(turnLabel, BorderPanel.Position.East)
    add(pictures, BorderPanel.Position.South)
    add(turnLabel, BorderPanel.Position.East)
    if (controller.game.turn.gamestate == Some(Finished(controller.game.turn)))
      endGame()
    repaint()
  }
  }
}