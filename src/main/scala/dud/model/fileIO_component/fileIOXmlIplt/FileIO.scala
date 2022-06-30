package dud
package model
package fileIO_component
package fileIOXmlIplt


import java.io.*
import game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import model.game_component.GameInterface

import scala.xml.{Node, NodeSeq, PrettyPrinter}

class FileIO extends FileIOInterface {

  override def load: GameInterface = {

    val player = Array[Player](Player("1", 0), Player("2", 0), Player("3", 0), Player("4", 0))
    val file = scala.xml.XML.loadFile("dud.xml")
    val turn = Turn((file \\ "game" \\ "turn").text.strip.toInt)
    val field = XmlToField(file \\ "game" \\ "field")

    Game(field, player, turn)
  }

  def XmlToField(field: NodeSeq) = {
    val size = (field \\ "size").text.strip.toInt
    val data = (field \\ "cells" \\ "building").toList
    Field(Array.tabulate(size,size)((x,y) => XmlToBuilding(data(y*size+x))))
  }

  def XmlToBuilding(building: Node) = {
    Building(building.text.strip.charAt(0).toString + building.text.strip.charAt(building.text.strip.length - 1).toString)
  }

  override def save(game: GameInterface): Unit = {
    val pw = new PrintWriter(new File("dud.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(gameToXml(game))
    pw.write(xml)
    pw.close
  }

  def gameToXml(game: GameInterface) = {
    <game>
      <field>
        {
          fieldToXml(game.field)
        }
      </field>
      <players>
        {
          for {
            row <- game.players.indices
          } yield playerToXml(game.players(row))
        }
      </players>
      <turn>
        {
          game.turn.turnsPlayed
        }
      </turn>
    </game>
  }

  def fieldToXml(field: Field) = {
    <size>
      {field.row}
    </size>
    <cells>
      {
        for {
          x <- field.cells
          y <- x
        } yield buildingToXml(y)
      }
    </cells>
  }

  def buildingToXml(building: Building) = {
    <building>
      {building.getClass.getSimpleName}
    </building>
  }

  def playerToXml(player: Player) = {
    <player>
      <remaining>
        {player.remaining}
      </remaining>
      <name>
        {player.name}
      </name>
    </player>
  }
}
