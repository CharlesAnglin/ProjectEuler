object helperFunctions {
  //For common reusable functions

  def elapsedTime(start: Long) = {
    val totalTime = System.currentTimeMillis - start
    if (totalTime < 1000) {
      println("Elapsed time: " + totalTime + " ms")
    } else if (totalTime < 60000) {
      println("Elapsed time: " + totalTime / 1000 + " sec, " + (totalTime - (totalTime / 1000) * 1000) + " ms")
    } else {
      println("Elapsed time: " + totalTime / 60000 + " min, " + (totalTime - (totalTime / 60000) * 60000) / 1000 + " sec, " + (totalTime - (totalTime / 1000) * 1000 + " ms"))
    }
  }

  val fibonacciStream = {
    def fib(a: Int, b: Int): Stream[Int] = a #:: fib(b, a + b)
    fib(0, 1)
  }

  val primeStream: Stream[Int] = 2 #:: Stream.from(3).filter(i => primeStream.takeWhile(j => j * j <= i).forall(i % _ > 0))

}
