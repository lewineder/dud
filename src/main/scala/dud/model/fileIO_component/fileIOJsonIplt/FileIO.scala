package dud.model.fileIO_component.fileIOJsonIplt

import com.google.inject.Guice
import com.google.inject.name.Names
import dud.DrunterUndDrueberModule
import dud.model.game_component.GameInterface
import net.codingwell.scalaguice.InjectorExtensions.*
import play.api.libs.json.*

import scala.io.Source

class FileIO extends FileIOInterface {

  override def load: GameInterface = {
    var game: GameInterface = null
    val source: String = Source.fromFile("game.json").getLines.mkString
    val json: JsValue = Json.parse(source)
    //val size = (json \ "game" \ "size").get.toString.toInt
    val injector = Guice.createInjector(new DrunterUndDrueberModule)

    for (index <- 0 until size * size) {
      val row = (json \\ "row")(index).as[Int]
      val col = (json \\ "col")(index).as[Int]
      val cell = (json \\ "cell")(index)
      val value = (cell \ "value").as[Int]
      game = game.set(row, col, value)
      val given = (cell \ "given").as[Boolean]
      val showCandidates = (cell \ "showCandidates").as[Boolean]
      if (given) game = game.setGiven(row, col, value)
      if (showCandidates) game = game.setShowCandidates(row, col)
    }
    game
  }

  override def save(game: GameInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("game.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close
  }

  implicit val cellWrites = new Writes[CellInterface] {
    def writes(cell: CellInterface) = Json.obj(
      "value" -> cell.value,
      "given" -> cell.given,
    "showCandidates" -> cell.showCandidates
    )
  }

  def buildingToJson(building: Building) = {

  }

  def fieldToJson(field: Field ) = {
    "field" -> Json.obj(
      "col" -> JsNumber(field.col),
      "row" -> JsNumber(field.row)
    )
  }
  def gameToJson(game: GameInterface) = {
    Json.obj(
      "game" -> Json.obj(
        "size" -> JsNumber(grid.size),
        "cells" -> Json.toJson(
          for {
            row <- 0 until grid.size;
            col <- 0 until grid.size
          } yield {
            Json.obj(
              "row" -> row,
              "col" -> col,
              "cell" -> Json.toJson(grid.cell(row, col))
            )
          }
        )
      )
    )
  }



}
