import scala.collection.mutable.ArrayBuffer

class pe001 {

//  Elapsed time: 190 ms

  def solve = println((0 until 1000).filter(a => a % 3 == 0 || a % 5 == 0).sum)

  def solve2 = {
    val numbers = List.range(0, 1000)
    val filter = numbers.filter(a => a % 3 == 0 || a % 5 == 0)
    println(filter.sum)
  }

  def solve3 = {
    val numbers = new ArrayBuffer[Int]
    for (num <- 0 to 999) {
      if (num % 5 == 0 || num % 3 == 0) {
        numbers += num
      }
    }
    println(numbers.sum)
  }
}
