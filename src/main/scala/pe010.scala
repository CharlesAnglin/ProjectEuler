class pe010 {

//  TODO: implement more efficient sieve

  //Elapsed time: 12 min, 14 sec, 794 ms

  def solve = {
    val primes = helperFunctions.primesUnder(2000000)
    val sum: BigInt = 0 //.sum returns an integer which overflows
    println(primes.foldLeft(sum)(_ + _))
    println(primes.length)
  }

}
