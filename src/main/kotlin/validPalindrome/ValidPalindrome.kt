package validPalindrome
/** Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 * letters and removing all non-alphanumeric characters, it reads the same forward and
 * backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 */
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.lastIndex
        while (start <= end) {
            while (!s[start].isLetterOrDigit() && start < s.lastIndex) {
                start++
            }
            while (!s[end].isLetterOrDigit() && end >= 1) {
                end--
            }
            if (start <= end
                    && s[start++].toLowerCase() != s[end--].toLowerCase()) {
                return false
            }
        }
        return true
    }

    fun isPalindrome2(s: String): Boolean {
        val letters = mutableListOf<Char>()
        for (char in s) {
            if (char.isLetterOrDigit()) {
                letters.add(char.toLowerCase())
            }
        }
        for (index in 0..letters.size/2) {
            if (letters[index] != letters[letters.lastIndex - index]) {
                return false
            }
        }
        return true
    }
}