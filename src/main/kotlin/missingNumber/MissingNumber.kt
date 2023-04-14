package missingNumber
/** Missing Number
 *
 *  Given an array nums containing n distinct numbers in the range [0, n], return the
 *  only number in the range that is missing from the array.
 */
class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        for (num in nums) {
            sum += num
        }
        return getRangeSum(nums.size) - sum
    }

    private fun getRangeSum(number: Int): Int {
        var sum = 0
        var n = 0
        while (n <= number) {
            sum += n++
        }
        return sum
    }
}