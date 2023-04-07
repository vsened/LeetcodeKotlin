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
}