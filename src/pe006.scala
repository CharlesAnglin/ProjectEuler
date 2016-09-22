class pe006 {

//  Elapsed time: 1 sec, 537 ms

  def solve = {
    var solution = squareOfSums(100) - sumOfSquares(100)
    println(solution)
  }

  def sumOfSquares(number: Int) = {
    val range = List.range(1, number + 1)
    range.foldLeft(0)(_ + scala.math.pow(_, 2).toInt)
  }

  def squareOfSums(number: Int) = {
    val range = List.range(1, number + 1)
    scala.math.pow((range.sum), 2).toInt
  }

}
