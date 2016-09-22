class pe009 {

//  Elapsed time: 476 ms

  def solve = {
    println(findTriples)
  }

  //  a < b < c
  //  a^2 + b^2 = c^2
  //  a + b + c = 1000

  //  c = 1000 - a - b
  //  c^2 = (1000 - a - b)^2
  //  a^2 + b^2 = 1000^2 - 1000a - 1000b - 1000a + a^2 + ab - 1000b + ab + b^2
  //  0 = 1000^2 - 2000a - 2000b + 2ab
  //  2000b - 2ab = 1000^2 - 2000a
  //  b(2000 - 2a) = 1000^2 - 2000a
  //  b = (1000^2 - 2000a) / (2000 - 2a)

  def findTriples: Int = {
    for (a <- 1 to 333) {
      val b = (math.pow(1000, 2) - 2000 * a) / (2000 - 2 * a)
      val c = 1000 - b - a
      if (c - math.floor(c) == 0) {
        return a * b.toInt * c.toInt
      }
    }
    0
  }
}
