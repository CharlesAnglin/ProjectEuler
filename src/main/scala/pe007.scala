class pe007 {

//  Elapsed time: 4 sec, 844 ms

  def solve = {
    val primes = primesUnder(150000)
    println("no of primes " + primes.length)
    println("greatest prime under: " + primes.last)
    println("10001st prime: " + primes(10000))
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
