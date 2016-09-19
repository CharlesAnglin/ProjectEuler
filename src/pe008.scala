class pe008 {

  def solve = {
    //    println(findGreatestProduct(4, number))
    var stuff = number(0).toInt
    println(stuff.toInt) //prints 55 but should be 7?????
  }

  val number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"

  def findGreatestProduct(amountOfDigits: Int, bigNumber: String) = {
    var indexOfGreatestProduct = 0 //records the index of the first character in the greatest product sequence
    var sumTotal = 0 //records the "score" of each potential sequence.
    var product = 1

    def findProduct(index: Int, lastSumTotal: Int): Unit = {
      val newSumTotal = lastSumTotal - bigNumber(index - 1) + bigNumber(index + amountOfDigits - 1)
      if (index == bigNumber.length - amountOfDigits) {
        return
      } else if (newSumTotal > sumTotal) {
        sumTotal = newSumTotal
        indexOfGreatestProduct = index
      }
      findProduct(index + 1, newSumTotal)
    }

    findProduct(1, 0)

    def calcProduct(index: Int, numbersLeft: Int, accumulator: Int): Int = {
      val multiplier = number(index) // debugger says this is:  '9' 57 ?????
      if (numbersLeft == 0) {
        accumulator
      } else {
        calcProduct(index + 1, numbersLeft - 1, accumulator * number(index).toInt)
      }
    }

    calcProduct(indexOfGreatestProduct, amountOfDigits, 1)

    //    for (a <- 0 to amountOfDigits - 1) {
    //      println(number(indexOfGreatestProduct + a))
    //      println(product)
    //      product = product * number(indexOfGreatestProduct + a)
    //      println(product)
    //    }
    //    product
  }

}
