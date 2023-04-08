package validAnagram
/** Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, typically using all the original letters exactly once.
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val input = mutableMapOf<Char, Int>()
        for (letter in s) {
            input[letter] = input.getOrDefault(letter, 0) + 1
        }
        val output = mutableMapOf<Char, Int>()
        for (letter in t) {
            input[letter] = input.getOrDefault(letter, 0) + 1
        }
        for (key in output.keys) {
            if (!input.containsKey(key) || input[key] != output[key]){
                return false
            }
        }
        return true
    }
}