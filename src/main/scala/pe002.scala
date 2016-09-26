import scala.collection.mutable.ArrayBuffer

class pe002 {

//  Elapsed time: 190 ms

  def solve = println(helperFunctions.fibonacciStream.takeWhile(_<4000000).filter(_%2==0).sum)

  def solve1 = {
    val fibNums = ArrayBuffer(1, 2)
    while (fibNums.last < 4000000) {
      fibNums += fibNums(fibNums.length - 2) + fibNums.last
    }
    println(fibNums.filter(num => num % 2 == 0).sum)
  }

  //fib is unused here
  def fib(i: Int): Int = {
    if (i == 0) {
      1
    } else if (i == 1) {
      2
    } else {
      fib(i - 1) + fib(i - 2)
    }
  }

}
