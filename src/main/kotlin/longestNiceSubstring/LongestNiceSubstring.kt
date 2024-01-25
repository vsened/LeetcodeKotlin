package longestNiceSubstring

/**
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b'
 * appears, but 'B' does not.
 *
 * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the
 * earliest occurrence. If there are none, return an empty string.
 */
class LongestNiceSubstring {
    fun longestNiceSubstring(s: String): String {
        val substring = getLongestNiceSubstring(s, 0, s.length)
        return s.substring(substring[0], substring[1])
    }

    private fun getLongestNiceSubstring(s: String, left: Int, right: Int): IntArray {
        var charset = getCharSet(s, left, right)

        for (i in left until right) {
            if (!charset.contains(s[i].lowercaseChar())
                || !charset.contains(s[i].uppercaseChar())) {
                val prefix = getLongestNiceSubstring(s, left, i)
                val suffix = getLongestNiceSubstring(s, i + 1, right)
                return if (prefix[1] - prefix[0] >= suffix[1] - suffix[0])
                    prefix else suffix
            }
        }
        return intArrayOf(left, right)
    }

    private fun getCharSet(s: String, left: Int, right: Int): Set<Char> {
        val charSet = HashSet<Char>()
        for (i in left until right) {
            charSet.add(s[i])
        }
        return charSet
    }

}