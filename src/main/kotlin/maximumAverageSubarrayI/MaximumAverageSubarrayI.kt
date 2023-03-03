package maximumAverageSubarrayI
/**
 * Maximum Average Subarray I.
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average
 * value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */
class MaximumAverageSubarrayI {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var max: Double = 0.0
        for (num in 0 until k){
            max += nums[num] * 1.0
        }
        max /= k
        var currentMax = max
        for (num in k until nums.size) {
            currentMax = (currentMax * k - nums[num - k] + nums[num] )/ k;
            if (currentMax > max) {
                max = currentMax
            }
        }
        return max
    }
}