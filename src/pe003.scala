import scala.collection.mutable.ArrayBuffer
import scala.math._

class pe003 {

  def solve = {
    val primes = primeList(600851475143L)   //replace with num/2

  }

  def primeList(bound : Long) : List[Long] = {

    def createPrimeList(list : List[Long], primes: ArrayBuffer[Long]): ArrayBuffer[Long] = {
      if(list.isEmpty){
        primes
      }else{
        primes += list(0)
        val filteredList = list.filter(num => num%list(0)!=0)    //replace with while loop?
        createPrimeList(filteredList,primes)
      }
    }

    val list : List[Long] = List.range(2, bound)
    val primes : ArrayBuffer[Long] = ArrayBuffer.empty
    createPrimeList(list, primes).toList
  }




  def primeChecker(prime : Int) : Boolean = {
    val nums = 2 to sqrt(prime).toInt
    for (num <- nums) {
      if (prime % num == 0) {
        return false
      }
    }
    true
  }

}
