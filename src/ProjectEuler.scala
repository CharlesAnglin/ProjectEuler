

object ProjectEuler {
  def main(args: Array[String]) {
    //60 seconds
    val start = System.currentTimeMillis()

    val problem = new pe010
    problem.solve

    helperFunctions.elapsedTime(start)
  }
}
