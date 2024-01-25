package shortestCompletingWord

/**
 * Given a string licensePlate and an array of strings words, find the shortest completing word in words.
 *
 * A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate,
 * and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the
 * word the same number of times or more.
 *
 * For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible
 * completing words are "abccdef", "caaacab", and "cbca".
 *
 * Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest
 * completing words, return the first one that occurs in words.
 */
class ShortestCompletingWord {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val lpMap = HashMap<Char, Int>()
        for (letter in licensePlate) {
            if (letter.isLetter()) {
                lpMap[letter.lowercaseChar()] = lpMap.getOrDefault(letter.lowercaseChar(), 0) + 1
            }
        }
        var minLength = Int.MAX_VALUE
        var minWord = ""
        for (word in words) {
            val cwMap = HashMap<Char, Int>()
            for (letter in word) {
                cwMap[letter.lowercaseChar()] = cwMap.getOrDefault(letter.lowercaseChar(), 0) + 1
            }
            var flag = true
            for (key in lpMap.keys) {
                if (!cwMap.containsKey(key) || lpMap[key]!! > cwMap[key]!!) {
                    flag = false
                    break
                }
            }
            if (flag && minLength > word.length) {
                minLength = word.length
                minWord = word
            }
        }
        return minWord
    }
}