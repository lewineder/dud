
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

    val cells = (jfile \ "field" \ "cells" \\ "name").toList


    val turns = Turn((jfile \ "turn").get.toString.toInt)
    val field = jsonToField(cells)
    val player = Array[Player](Player("1", 0), Player("2", 0), Player("3", 0), Player("4", 0))



    Game(field, player, turns)
  }

  //etwas kürzere Version wie bei XML - allerdings auch etwas komplizierter
  def jsonToField(data: List[JsValue]): Field = {
    val size = scala.math.sqrt(data.length).toInt
    Field(Array.tabulate(size,size)((y,x) => jsonToBuilding(data(y*size+x))))
  }

  def jsonToBuilding(building: JsValue): Building = {
    val house = building.toString.strip.stripPrefix("\"").stripSuffix("\"")
    Building(house.charAt(0).toString + house.charAt(house.length - 1).toString)
  }




  override def save(game: GameInterface) = {
    val pw = new PrintWriter(new File("dud.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close
  }

  def gameToJson(game: GameInterface) = {
    Json.obj(
      "field" -> fieldToJson(game.getField().cells),
      "turn" -> game.turn.turnsPlayed
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
