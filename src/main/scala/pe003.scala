import scala.collection.mutable.ArrayBuffer
import scala.math._
import scala.util.control.Breaks._

class pe003 {

//  Elapsed time: 1 sec, 444 ms

  def solve = {
    val num = BigInt(600851475143L)
    println(primeDivisors(600851475143L))
  }

  def primeDivisors(bound: Long): Long = {
    var newBound = bound
    var divisor = 2
    var largestDivisor = 0

    while (divisor <= newBound) {
      if (newBound % divisor == 0) {
        newBound = newBound / divisor
        largestDivisor = divisor
        while (newBound % divisor == 0) {
          newBound = newBound / divisor
        }
      }
      divisor += 1
    }
    largestDivisor
  }


  //  def primeDivisors (bound : Long) : List[Long] = {
  //
  //    def recursive (bound : Long, primes : ArrayBuffer[Long]) : List[Long] = {
  //      val sqrtBound = sqrt(bound).toInt
  //      var newBound = 0
  //      var index = 2
  //      breakable {
  //        while (index < sqrtBound+ 1) {
  //          if (bound % index == 0) {
  //            primes += index
  //            newBound = (bound / index).toInt
  //            break
  //          }
  //          index += 1
  //        }
  //      }
  //      if(index == sqrtBound+1){
  //        primes += bound
  //        return primes.toList
  //      }else {
  //        return recursive(newBound.toLong, primes)
  //      }
  //    }
  //
  //    val primes : ArrayBuffer[Long] = ArrayBuffer.empty
  //    recursive(bound, primes)
  //  }


  /**
    * finds all primes less sqrt(bound) and keeps the ones which bound
    *
    * @param bound Int
    * @return list of prime factors of bound
    */
  def primeList(bound: Long): List[Int] = {

    def createPrimeList(list: List[Int], primes: ArrayBuffer[Int]): ArrayBuffer[Int] = {
      if (list.isEmpty) {
        primes
      } else {
        if (bound % list(0) == 0) {
          primes += list(0)
        }
        val filteredList = list.filter(num => num % list(0) != 0)
        createPrimeList(filteredList, primes)
      }
    }

    val list: List[Int] = List.range(2, sqrt(bound).toInt)
    val primes: ArrayBuffer[Int] = ArrayBuffer.empty
    createPrimeList(list, primes).toList
  }


  //not used
  def primeChecker(prime: Int): Boolean = {
    val nums = 2 to sqrt(prime).toInt
    for (num <- nums) {
      if (prime % num == 0) {
        return false
      }
    }
    true
  }

}
