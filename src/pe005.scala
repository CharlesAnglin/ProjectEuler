class pe005 {

  def solve = {
//    println(2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17 * 19)
    println(smallestEvenlyDivisible(20))
  }

  //  primes below 21: 2, 3, 5, 7, 11, 13, 17, 19
  //
  //  2      2
  //  3      3
  //  4      2^2
  //  5      5
  //  6      2 * 3
  //  7      7
  //  8      2^3
  //  9      3^2
  //  10     2 * 5
  //  11     11
  //  12     2^2 * 3
  //  13     13
  //  14     2 * 7
  //  15     3 * 5
  //  16     2^4
  //  17     17
  //  18     2 * 3^2
  //  19     19
  //  20     2^2 * 5
  //
  //  highest powers: 2^4, 3^2, 5, 7, 11, 13, 17, 19
  //  so answer is 2^4 * 3^2 * 5 * 7 * 11 * 13 * 17 * 19

  def smallestEvenlyDivisible(number: Int) = {
    //finds the smallest evenly divisible positive number under given number.
    var solution = 1
    for (a <- 2 to number; b <- 2 to number) {
      //Initially a=2 while b cycles through 2 to 20
      if (solution % b != 0 && (solution * a) % b == 0) {
        solution *= a
      }
    }
    solution
  }

}
