import scala.io.StdIn.readLine

@main
def field(): Unit =
  println(
    readyStringsFromArray(
      readyStringsFromMatrix(
        genStringsFromMatrix(
          genFieldMatrix(
            10)))))