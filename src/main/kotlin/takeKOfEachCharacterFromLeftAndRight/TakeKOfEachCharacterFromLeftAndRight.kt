package takeKOfEachCharacterFromLeftAndRight

import kotlin.math.max
import kotlin.math.min

/**
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute,
 * you may take either the leftmost character of s, or the rightmost character of s.
 *
 * Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not
 * possible to take k of each character.
 */
class TakeKOfEachCharacterFromLeftAndRight {
    fun takeCharacters(s: String, k: Int): Int {
        val counter = s.groupingBy { it }
            .eachCount()
            .toMutableMap()
            .withDefault { 0 }
        if (listOf('a', 'b', 'c').map(counter::getValue).any { it < k }) {
            return -1
        }
        var (left, maxWindow) = 0 to 0
        for ((right, c) in s.withIndex()) {
            counter.merge(c, -1, Int::plus)
            while (counter.getValue(c) < k) {
                counter.merge(s[left++], 1, Int::plus)
            }
            maxWindow = maxOf(maxWindow, right - left + 1)
        }
        return s.length - maxWindow
    }

    fun takeCharacters2(s: String, k: Int): Int {
        val symbolsToCounters = IntArray(3) { -k }
        var maxLength = 0
        for (i in s.indices) {
            symbolsToCounters[s[i] - 'a']++
        }
        for (i in symbolsToCounters.indices) {
            if (symbolsToCounters[i] < 0)
                return -1
        }

        var currentSymbolsToCounters = IntArray(3)
        var leftPointer = 0
        var rightPointer = 0
        while (leftPointer < s.length && rightPointer < s.length) {
            currentSymbolsToCounters[s[rightPointer] - 'a']++
            for (i in symbolsToCounters.indices) {
                if (symbolsToCounters[i] < currentSymbolsToCounters[i]) {
                    currentSymbolsToCounters[s[leftPointer] - 'a']--
                    if (leftPointer == rightPointer) {
                        leftPointer++
                        rightPointer++
                    } else {
                        currentSymbolsToCounters[s[rightPointer] - 'a']--
                        leftPointer++
                    }
                    break
                }
                if (i == symbolsToCounters.size - 1) {
                    maxLength = max(maxLength, rightPointer - leftPointer + 1)
                    rightPointer++
                }
            }
        }
        return s.length - maxLength
    }

    fun takeCharacters3(s: String, k: Int): Int {
        val count = IntArray(3)
        for (char in s) {
            count[char - 'a']++
        }
        if (isValid(count, k)) return -1
        var result = s.length
        var left = 0
        for (right in s.indices) {
            count[s[right] - 'a']--
            while (
                left <= right &&
                isValid(count, k)
            ) {
                count[s[left] - 'a']++
                left++
            }
            result = min(count.sum(), result)
        }
        return result
    }
    private fun isValid(count: IntArray, k: Int): Boolean = count[0] < k || count[1] < k || count[2] < k

}