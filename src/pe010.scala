class pe010 {

  def solve = {
    val primes = helperFunctions.primesUnder(2000000)
    val sum: BigInt = 0 //.sum returns an integer which overflows
    println(primes.foldLeft(sum)(_ + _))
  }

}
