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
    fib(0,1)
  }

  val primeStream = {
      def p(stream: Stream[Int]): Stream[Int] = stream.head #:: p(stream.filter(_ % stream.head != 0))
      p(Stream.from(2))
  }

  def primesUnder(number: Int) = {

    def findPrimes(primes: List[Int], range: List[Int]): List[Int] = {
      if (range.isEmpty) {
        return primes.reverse
      }
      findPrimes(range.head :: primes, range.filter(_ % range.head != 0))
    }

    findPrimes(List.empty, List.range(2, number))
  }

}
