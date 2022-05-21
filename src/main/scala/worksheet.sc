
trait Building:
  def print(color: String): String
  override def toString = print("\u001b[31m")


case class Strasse1() extends Building:
  def print(color: String): String = color + "+---------+\n" + "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n"

val a = new Strasse1

println(a.toString())
