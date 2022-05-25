package dud
package aview
package gui

import controller.*
import util.*

import scala.swing.*
import scala.swing.BorderPanel.Position.*
import event.*
import java.awt.{ Color, Graphics2D }
import scala.util.Random

class CellClicked(val row: Int, val column: Int) extends Event

class Gui(observable: Controller) extends Frame {

  listenTo(observable)

  title = "Willkommen zu drunter und drüber"


  def testPanel = new FlowPanel {
  }


  contents = new BorderPanel {
    add(testPanel, BorderPanel.Position.North)
  }

  visible = true


}

