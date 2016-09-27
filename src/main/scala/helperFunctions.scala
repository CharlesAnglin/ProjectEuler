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

  val primeStream = {
    //Use prime function for primes over 10000.
    def p(stream: Stream[Int]): Stream[Int] = stream.head #:: p(stream.filter(_ % stream.head != 0))
    p(Stream.from(2))
  }

  //outrageously fast - why???
  lazy val ps: Stream[Int] = 2 #:: Stream.from(3).filter(i => ps.takeWhile(j => j * j <= i).forall(i % _ > 0))

  def primesUnder(number: Int) = {
    //Starts to be faster than streams when primes exceed 10000, significantly faster for primes over 20000.
    def findPrimes(primes: Vector[Int], range: Vector[Int]): Vector[Int] = {
      if (range.isEmpty) {
        return primes.reverse
      }
      findPrimes(range.head +: primes, range.filter(_ % range.head != 0))
    }

    findPrimes(Vector.empty, Vector.range(2, number))
  }

  def findLargestPrime(number: Int) = {
    (2 to number).filter(i => (2 to math.sqrt(i).toInt).forall(i % _ > 0))
  }

}
