package verifyingAnAlienDictionary
/** Verifying an Alien Dictionary
 *
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly
 * in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographically in this alien
 * language.
 */
class VerifyingAnAlienDictionary {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val alphabet = HashMap<Char, Int>()
        for (i in order.indices) {
            alphabet[order[i]] = i + 1
        }
        for (i in 1..words.lastIndex) {
            var cursor = 0
            while (true) {
                if (alphabet[words[i-1][cursor]]!! > alphabet[words[i][cursor]]!!) {
                    return false
                } else if (alphabet[words[i-1][cursor]]!! < alphabet[words[i][cursor]]!!) {
                    break
                } else {
                    if (words[i-1].length - 1 == cursor && words[i].length - 1 > cursor) {
                        break
                    } else if (words[i-1].length - 1 > cursor && words[i].length - 1 == cursor) {
                        return false
                    } else if (words[i-1].length - 1 == cursor && words[i].length - 1 == cursor) {
                        break
                    } else {
                        cursor++
                    }
                }
            }
        }
        return true
    }
}