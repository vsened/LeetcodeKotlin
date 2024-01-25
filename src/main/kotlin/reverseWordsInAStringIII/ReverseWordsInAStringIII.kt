package reverseWordsInAStringIII
/** Reverse Words in a String III
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 */
class ReverseWordsInAStringIII {
    fun reverseWords(s: String): String {
        val words = s.split(" ").toMutableList()
        for (index in words.indices) {
            words[index] = words[index].reversed()
        }
        return words.joinToString(" ")
    }

    fun reverseWords2(s: String) = s.split(" ").joinToString(" ") { word -> word.reversed() }

    fun reverseWords3(s: String): String {
        val result = CharArray(s.length)
        var wordStart = 0
        var nextWord = 0
        var nextSpace = 0

        while (nextWord < s.length) {
            while (nextSpace < s.length && s[nextSpace] != ' ') nextSpace++

            nextWord = nextSpace + 1

            while (wordStart != nextWord - 1) {
                result[wordStart] = s[nextSpace - 1]
                wordStart++
                nextSpace--
            }

            if (wordStart < s.length) {
                result[wordStart] = s[wordStart]
            }
            wordStart++
            nextSpace = wordStart
        }
        return result.toString()
    }
}