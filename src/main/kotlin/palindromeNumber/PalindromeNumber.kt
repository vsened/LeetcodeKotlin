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
     * math manipulation
     */
    fun isPalindrome2(x: Int): Boolean {
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
}