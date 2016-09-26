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
