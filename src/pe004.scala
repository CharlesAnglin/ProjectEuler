class pe004 {

//  Elapsed time: 415 ms

  def solve = {
    println(findLargestPalindrome)
  }

  def isPalindrome(number: String): Boolean = {
    val length = number.length
    length match {
      case 1 => true
      case 2 => if (number(0) == number(1)) true else false
      case _ => if (number(0) == number(length - 1)) isPalindrome(number.slice(1, length - 1)) else false
    }
  }

  def findLargestPalindrome = {
    def helper(nextNumber: Int): Int = {
      if (isPalindrome(nextNumber.toString) == true && isThreeDigitProduct(nextNumber)) {
        nextNumber
      }
      else {
        helper(nextNumber - 1)
      }
    }

    helper(999 * 999)
  }

  def isThreeDigitProduct(number: Int, divisor: Int = 999): Boolean = {
    if (divisor == 99) {
      return false
    }
    if (number % divisor == 0 && (number / divisor).toString.length == 3) {
      true
    } else {
      isThreeDigitProduct(number, divisor - 1)
    }
  }
}
