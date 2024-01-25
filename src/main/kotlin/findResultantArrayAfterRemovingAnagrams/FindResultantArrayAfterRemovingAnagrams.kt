package findResultantArrayAfterRemovingAnagrams

/**
 * You are given a 0-indexed string array words, where words`[i]` consists of lowercase English letters.
 *
 * In one operation, select any index i such that 0 < i < words.length and words`[i - 1]` and words`[i]` are anagrams, and
 * delete words`[i]` from words. Keep performing this operation as long as you can select an index that satisfies the
 * conditions.
 *
 * Return words after performing all operations. It can be shown that selecting the indices for each operation in any
 * arbitrary order will lead to the same result.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original
 * letters exactly once. For example, "dacb" is an anagram of "abdc".
 */
class FindResultantArrayAfterRemovingAnagrams {
    fun removeAnagrams(words: Array<String>): List<String> {
        if (words.size < 2) {
            return words.toList()
        }
        val result = words.toMutableList()
        var flag = true
        while (flag) {
            var start = 1
            var startSize = result.size
            for (i in start..result.lastIndex) {
                if (checkAnagrams(result[i], result[i - 1])) {
                    result.removeAt(i)
                    break
                }
            }
            if (startSize == result.size) {
                flag = false
            }
        }
        return result
    }

    private fun checkAnagrams(first: String, second: String): Boolean {
        if (first.length != second.length) return false
        val accumulator = HashMap<Char, Int>()
        first.forEach {  letter ->
            accumulator[letter] = accumulator.getOrDefault(letter, 0) + 1
        }
        second.forEach {  letter ->
            if (!accumulator.containsKey(letter)) {
                return false
            }
            else {
                if (accumulator[letter] == 0) return false
                accumulator[letter] = accumulator[letter]!! - 1
            }
        }
        return true
    }

    fun removeAnagrams2(words: Array<String>): List<String> {
        val resList = mutableListOf<String>()
        val anagrams = mutableListOf<HashMap<Char,Int>>()

        for (word in words){
            val temp = HashMap<Char, Int>()
            var isAnagram = false
            for (ch in word){
                temp[ch] = (temp[ch] ?: 0) + 1
            }
            for (an in anagrams){
                if (temp.equals(an)){
                    isAnagram = true
                    break
                }
            }
            if(!isAnagram){
                anagrams.clear()
                anagrams.add(temp)
                resList.add(word)
            }
        }
        return resList.toList()
    }

    fun removeAnagrams3(words: Array<String>): List<String> {
        val uniqueWords = mutableListOf<String>()
        var symbolsToCounters = IntArray(ALPHABET_SIZE)
        for (i in words.indices) {
            val currentSymbolsToCounters = countSymbols(words[i])
            for (j in symbolsToCounters.indices) {
                if (symbolsToCounters[j] != currentSymbolsToCounters[j]) {
                    uniqueWords.add(words[i])
                    symbolsToCounters = currentSymbolsToCounters
                    break
                }
            }
        }
        return uniqueWords.toList()
    }

    private fun countSymbols(word: String): IntArray {
        val symbolsToCounters = IntArray(ALPHABET_SIZE)
        for (i in word.indices) {
            symbolsToCounters[word[i] - 'a']++
        }
        return symbolsToCounters
    }

    companion object {
        private const val ALPHABET_SIZE = 26
    }
}