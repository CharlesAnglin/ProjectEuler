

object ProjectEuler extends App {
  //60 seconds limit
  val start = System.currentTimeMillis()

  //  val problem = new pe003
  //  problem.solve

  helperFunctions.elapsedTime(start)

  var primesUnderCount: BigInt = 0
  var primesUnder3Count: BigInt = 0

  val start2 = System.currentTimeMillis()

//  println(helperFunctions.primesUnder(1000000).last)

  helperFunctions.elapsedTime(start2)

  val start3 = System.currentTimeMillis()

  println(helperFunctions.primesUnder3(1000000).last)

  helperFunctions.elapsedTime(start3)

  val start4 = System.currentTimeMillis()

  println(helperFunctions.primesUnder4(1000000).last)

  helperFunctions.elapsedTime(start4)






  def primesUnderCounter(subject: Int, head : Int): Boolean = {
    primesUnderCount += 1
    subject % head != 0
  }

  def primesUnder3Counter(subject: Int, counter: Int): Boolean = {
    primesUnder3Count += 1
    counter % subject > 0
  }

  def primesUnder(number: Int) = {
    //Starts to be faster than streams when primes exceed 10000, significantly faster for primes over 20000.
    def findPrimes(primes: Vector[Int], range: Vector[Int]): Vector[Int] = {
      if (range.isEmpty) {
        return primes.reverse
      }
      findPrimes(range.head +: primes, range.filter(primesUnderCounter(_, range.head)))
    }

    findPrimes(Vector.empty, Vector.range(2, number))
  }

  def primesUnder3(number: Int) = {
    // completes 20,000,000 in 31 sec
    def findPrimes(primes: Vector[Int], counter: Int): Vector[Int] = {
      if (counter == 1) {
        return primes
      } else if ((2 to math.sqrt(counter).toInt).forall(primesUnder3Counter(_, counter))) {
        findPrimes(counter +: primes, counter - 1)
      } else {
        findPrimes(primes, counter - 1)
      }
    }
    findPrimes(Vector.empty, number)
  }

}