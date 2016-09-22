class pe008 {

//  Elapsed time: 395 ms

  def solve = {
    println(findGreatestProduct(13, number))
  }

  val number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"

  def findGreatestProduct(amountOfDigits: Int, bigNumber: String) = {
    //to get maximum speed we try to avoid calculating the product of every single set we find the sets with the largest sums
    def hasNoZeros(index: Int): Boolean = {
      for (digit <- 0 to amountOfDigits - 1) {
        if (bigNumber(index + digit).asDigit == 0) {
          return false
        }
      }
      true
    }

    def findProduct(index: Int, SumTotal: Int, greatestSumTotal: Int, indexOfGreatestProduct: Int): BigInt = {
      if (index + amountOfDigits - 1 == bigNumber.length) {
        return calcProduct(indexOfGreatestProduct)
      }
      val newSumTotal = SumTotal - bigNumber(index - 1) + bigNumber(index + amountOfDigits - 1)
      if (newSumTotal > greatestSumTotal && hasNoZeros(index) && calcProduct(indexOfGreatestProduct) < calcProduct(index)) {
        //need to compare calcProducts as 10+2 = 12, 10*2=20, 6+6=12, 6*6=36
        findProduct(index + 1, newSumTotal, newSumTotal, index)
      } else {
        findProduct(index + 1, newSumTotal, greatestSumTotal, indexOfGreatestProduct)
      }
    }

    def calcProduct(index: Int, numbersLeft: Int = amountOfDigits, accumulator: BigInt = 1): BigInt = {
      if (numbersLeft == 0) {
        accumulator
      } else {
        println(bigNumber(index).asDigit)
        calcProduct(index + 1, numbersLeft - 1, accumulator * bigNumber(index).asDigit)
      }
    }

    findProduct(1, 0, 0, 0)
  }

}
