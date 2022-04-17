import scala.io.StdIn.readLine

@main
def field(): Unit =

  val tmp = tuiStartUpMenu()

  println(
    readyStringsFromArray(
      readyStringsFromMatrix(
        genStringsFromMatrix(
          passNewStateToField(
            passNewStateToField(
              passNewStateToField(
                passNewStateToField(
                  passNewStateToField(
                    passNewStateToField(
                      passNewStateToField(
                        genFieldMatrix(10), 1, 1, 1
                        ), 3, 2, 2
                          ), 4, 6, 4
                            ), 1, 8, 3
                              ), 2, 2, 11
                                ), 2, 3, 10
                                  ), 3, 3, 12
                                  )))))