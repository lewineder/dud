package dud.model

object PhantomPlayer {
  def apply (arr: Array[Array[Building]]) : Array[Array[Building]]  =
    val rd = scala.util.Random.shuffle(0.until (arr.size * arr(0).size))
    for (i <- 0 until (((arr.size * arr(0).size) / 20) * 4)) {
      arr(rd(i)/arr(0).size)(rd(i) % arr(0).size) = getBuild(i%4)
    }
    arr

  def getBuild = Array(Building.H1, Building.H2, Building.H3, Building.H4)

  

  /*
  val build = Array(Building.H1, Building.H2, Building.H3, Building.H4)
  val n = (arr.size * arr(0).size) / 8
  val rd = scala.util.Random.shuffle(0.until (arr.size * arr(0).size))
  for (i <- 0 until n) {
    arr(rd(i)/arr(0).size)(rd(i) % arr(0).size)  = build(i%4)
  }
  arr
  */

    /*
    val n = 4
    var rd = Seq.fill(n)((scala.util.Random.between(0, arr.size), scala.util.Random.between(0, arr(0).size))).toSet.toList
    while (rd.size < 4) {
      rd = Seq.fill(n)((scala.util.Random.between(0, arr.size), scala.util.Random.between(0, arr(0).size))).toSet.toList
    }
    val build = Array(Building.H1, Building.H2, Building.H3, Building.H4)
    for (i <- 0 to n-1)
      arr(rd(i)(0)) (rd(i)(1)) = build(i)

    arr
    */

    /*
    val v1 = scala.util.Random.shuffle(0 to (arr.size-1))
    val v2 = List.fill(arr.size-1)(arr.size).map(scala.util.Random.nextInt)
    arr(v1(0))(v2(0)) = Building.H1
    arr(v1(1))(v2(1)) = Building.H2
    arr(v1(2))(v2(2)) = Building.H3
    arr(v1(3))(v2(3)) = Building.H4
    arr(arr.size-1)(arr(0).size-1) = Building.S2

    arr
    */

    /*
    def arrShuffle(arr: Array[Array[Building]]) =  {
    Random random = new Random();

    for (int i = a.length - 1; i > 0; i--) {
      for (int j = a[i].length - 1; j > 0; j--) {
        int m = random.nextInt(i + 1);
        int n = random.nextInt(j + 1);

        int temp = a[i][j];
        a[i][j] = a[m][n];
        a[m][n] = temp;
      }
    }

      arr.size -1 until 0 by -1  map(
        row.size - 1 until 0 by -1 map (
          Random
        )
      )
    }
    */
}
