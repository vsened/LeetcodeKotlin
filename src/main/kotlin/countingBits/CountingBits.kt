package countingBits
/**
 * Counting Bits.
 * Given an integer n, return an array ans of length n + 1
 * such that for each i (0 <= i <= n), ans[i] is the number
 * of 1's in the binary representation of i.
 */
class CountingBits {
    /**
     * Using string's method.
     */
    fun countBits(n: Int): IntArray {
        val result = IntArray(n+1)
        for (num in 0..result.size) {
            result[num] = num.toString(2).replace("0", "").length
        }
        return result
    }
}