
package dud
package model
package fileIO_component
package fileIOJsonIplt

import java.io.*
import play.api.libs.json.*
import play.api.libs.json.JsPath.\
import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions.*
import dud.DrunterUndDrueberModule
import dud.model.fileIO_component.FileIOInterface
import dud.model.game_component.GameInterface
import game_component.BaseIplt.{Building, Field, Game, Player, Turn}

import java.io.*
import scala.io.Source

class FileIO extends FileIOInterface {

  override def load: GameInterface = {

    val file: String = Source.fromFile("dud.json").getLines.mkString
    val jfile: JsValue = Json.parse(file)

    val names = (jfile \ "players").get.as[List[JsObject]]

    val cells = (jfile \ "field").get.as[List[JsObject]]
    val turns = Turn((jfile \ "turn").get.as[Int])

    val field = jsonToField(cells)
    val players = jsonToPlayers(names)


    Game(field, players, turns)
  }

  def jsonToPlayers(names: List[JsObject]) = {
    Array.tabulate(names.length)(
      for {
        player <- names
      } yield Player((player \ "name").get.toString, (player \ "remaining").get.as[Int])
    )
  }


  //etwas kürzere Version wie bei XML - allerdings auch etwas komplizierter
  def jsonToField(data: List[JsObject]): Field = {
    val size = scala.math.sqrt(data.length).toInt
    Field(Array.tabulate(size,size)((x,y) => jsonToBuilding(data(y*size+x))))
  }

  def jsonToBuilding(building: JsObject): Building = {
    Building(building.toString.charAt(0).toString + building.toString.charAt(building.toString.length - 1).toString)
  }


  override def save(game: GameInterface) = {
    val pw = new PrintWriter(new File("dud.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close
  }

  def gameToJson(game: GameInterface) = {
    Json.obj(
      "players" -> playersToJson(game.getPlayers()),
      "field" -> fieldToJson(game.getField().cells),
      "turn" -> game.turn.turnsPlayed
    )
  }

  def playersToJson(players: Array[Player]) = {
    Json.obj(
      "players" -> {
        for {
          x <- players
        } yield playerToJson(x)
      }
    )
  }

  def playerToJson(player: Player) = {
    Json.obj(
      "name" -> player.name,
      "remaining" -> player.remaining
    )
  }



  def fieldToJson(cells: Array[Array[Building]]) = {
    Json.obj(
      "cells" -> {
        for {
          x <- cells
          y <- x
        } yield buildingToJson(y)
      }
    )
  }

  def buildingToJson(building: Building) = {
    Json.obj(
      "name" -> building.getClass.getSimpleName
    )
  }
}
