

object ProjectEuler extends App {
  //60 seconds limit
  val start = System.currentTimeMillis()

  val problem = new pe011
  problem.solve

  helperFunctions.elapsedTime(start)
}
