package palindromeNumber

/**
 * 9. Palindrome Number
 *
 * Given an integer x, return true if x is palindrome integer.
 */

class PalindromeNumber {
    /**
     * Using string
     */
    fun isPalindrome1(x: Int): Boolean {
        val number: String = x.toString();
        for (i in 0 until (number.length / 2))
            if (number[i] != number[number.length - 1 - i])
                return false
        return true
    }

    /**
     * Another string way
     */
    fun isPalindrome2(x: Int): Boolean = "$x" == "$x".reversed()

    /**
     * Math manipulation
     */
    fun isPalindrome3(x: Int): Boolean {
        var number = x
        var reverseNumber: Int = 0
        while (number > 0){
            reverseNumber = reverseNumber * 10 + (number % 10)
            number /= 10
        }
        if (reverseNumber == x)
            return true
        return false
    }

    /**
     * Using lambda
     */
    fun isPalindrome4(x: Int): Boolean = x.toString().let { it == it.reversed() }

}