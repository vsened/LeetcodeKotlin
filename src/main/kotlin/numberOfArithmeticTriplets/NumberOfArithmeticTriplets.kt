package numberOfArithmeticTriplets

/**
 * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k)
 * is an arithmetic triplet if the following conditions are met:
 *
 * i < j < k,
 *
 * nums`[j]` - nums`[i]` == diff, and
 *
 * nums`[k]` - nums`[j]` == diff.
 *
 * Return the number of unique arithmetic triplets.
 */
class NumberOfArithmeticTriplets {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val numbers = nums.toSet()
        return nums.count {
            numbers.contains(it)
                    && numbers.contains(it + diff)
                    && numbers.contains(it + 2 * diff)
        }
    }

    fun arithmeticTriplets2(nums: IntArray, diff: Int): Int {
        var result = 0
        for (i in 0 until (nums.size -2)) {
            if (isIndexExist(nums[i] + diff,i+1,nums) && isIndexExist(nums[i] + diff*2,i+2,nums)) result++
        }
        return result
    }
    private fun isIndexExist(value: Int, start: Int, nums: IntArray): Boolean {
        var left = start-1
        var right = nums.size
        while (right - left > 1) {
            var mid = (left + right) / 2
            if (nums[mid] == value) {
                return true
            } else if (nums[mid] > value) {
                right = mid
            } else {
                left = mid
            }
        }
        return false
    }

    fun arithmeticTriplets3(nums: IntArray, diff: Int): Int {
        val map = BooleanArray(201)
        for (n in nums) map[n] = true
        var cnt = 0
        for (n in nums) {
            if (n - diff >= 0 && map[n - diff] && n + diff <= 200 && map[n + diff]) cnt++
        }
        return cnt
    }
}