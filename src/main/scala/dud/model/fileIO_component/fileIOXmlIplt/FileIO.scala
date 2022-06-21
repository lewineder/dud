/*
package dud
package model
package fileIO_component
package fileIOXmlIplt

import game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import model.game_component.GameInterface
import com.google.inject.{Guice, Inject}

import java.io.*
import scala.xml.{NodeSeq, PrettyPrinter}

class FileIO extends FileIOInterface {

  override def load: GameInterface = {
    val file = scala.xml.XML.loadFile("dud.xml")
    return (file \\ "game").text.trim()

    //todo:
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
    <cell>
      {
        for {
          x <- 0 until field.row
          y <- 0 until field.col
        } yield field.cells(x, y)
      }
    </cell>
  }

  def playerToXml(player: Player) = {
    <player>
      <remaining>
        player.remaining
      </remaining>
      <name>
        player.name
      </name>
    </player>
  }
}
*/