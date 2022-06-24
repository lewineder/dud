import dud.model.game_component.BaseIplt.{Building, Field, Game, Player, Turn}
import dud.model.game_component.GameInterface

import java.io.{File, PrintWriter}
import scala.xml.{NodeSeq, PrettyPrinter}


val gm = new Game()


def buildingToXml(building: Building) = {
  <building>
    <type>building.getClass.getSimpleName</type>
  </building>
}


def playerToXml(player: Player) = {
  <player>
      {player.remaining}
  </player>
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



def save(game: GameInterface)= {
  gameToXml(game)
}


def XmlToBuilding(building: NodeSeq) = {
  Building(building.text.charAt(0).toString + building.text.charAt(building.text.length - 1).toString)
}



def XmlToField(field: NodeSeq) = {
  val size = (field \ "size").text.toInt
  val data = (field \ "cells" \ "Building" \ "type")
  Field(Array.tabulate(size,size)((x,y) => XmlToBuilding(data(y*size+x))))
}


def XmlToRemain(players: NodeSeq) = {
  for {
    x <- players
  } yield x
}



val saved = save(gm)



def load: GameInterface = {

  val file = saved

  val remain = XmlToRemain(file \\ "game" \\ "players")

  val players = Array[Player](Player("Spieler 1", remain(0).text.toInt), Player("Spieler 2", remain(1).text.toInt), Player("Spieler 3", remain(2).text.toInt), Player("Spieler 4", remain(3).text.toInt) )

  print(players)

  val turn = Turn((file \ "game" \ "turn").text.toInt)

  print(turn)

  val field = XmlToField(file \ "game" \ "field")

  Game(field, players, turn)
}



load
