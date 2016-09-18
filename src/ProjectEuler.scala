

object ProjectEuler {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis()

    val problem = new pe004
    problem.solve

    val totalTime = System.currentTimeMillis - start
    println("Elapsed time: %1d sec".format(totalTime/1000))  //rounded to lowest sec.
  }
}
