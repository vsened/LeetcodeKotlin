package reverseVowelsOfAString

/** Reverse Vowels of a String
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 */
class ReverseVowelsOfAString {
    fun reverseVowels(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var chrs = s.toCharArray()
        var l = 0
        var r = chrs.lastIndex
        while(l < r) {
            while(l<r && chrs[l] !in vowels) l++
            while(l<r && chrs[r] !in vowels) r--
            if (l < r) chrs[l] = chrs[r].also { chrs[r] = chrs[l] }
            r--
            l++
        }
        return String(chrs)
    }
}