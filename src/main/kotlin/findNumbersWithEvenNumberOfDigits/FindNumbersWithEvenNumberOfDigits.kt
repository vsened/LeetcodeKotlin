package findNumbersWithEvenNumberOfDigits
/** Find Numbers with Even Number of Digits
 *
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */
class FindNumbersWithEvenNumberOfDigits {
    fun findNumbers(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            if (num.toString().length % 2 == 0) {
                result++
            }
        }
        return result
    }

    fun findNumbers2(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            if (getCountOfDigits(num) % 2 == 0) {
                result++
            }
        }
        return result
    }

    private fun getCountOfDigits(num: Int): Int {
        var result = 0
        var number = num
        while (num > 0) {
            number /= 10
            result++
        }
        return result
    }
}