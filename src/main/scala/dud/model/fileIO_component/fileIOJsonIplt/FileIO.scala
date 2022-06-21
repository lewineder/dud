/* package dud.model.fileIO_component.fileIOJsonIplt

import com.google.inject.Guice
import com.google.inject.name.Names
import dud.DrunterUndDrueberModule
import dud.model.fileIO_component.FileIOInterface
import dud.model.game_component.GameInterface
import net.codingwell.scalaguice.InjectorExtensions.*
import play.api.libs.json.*

import java.io.*
import scala.io.Source

class FileIO extends FileIOInterface {

  override def load: GameInterface = {
    val file: String = Source.fromFile("dud.json").getLines.mkString
    val jfile: JsValue = Json.parse(file)

    var game: GameInterface = null

    //todo:

  }




  override def save(game: GameInterface): Unit = {
    val pw = new PrintWriter(new File("dud.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close
  }

  def gameToJson(game: GameInterface): Unit = {
    Json.obj(
      "field" -> game.getField(),
      "players" -> game.getPlayers(),
      "turn" -> game.turn,
    )
  }
}
*/
