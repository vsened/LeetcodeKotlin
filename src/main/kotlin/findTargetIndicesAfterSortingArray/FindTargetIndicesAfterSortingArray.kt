package findTargetIndicesAfterSortingArray

/**
 * You are given a 0-indexed integer array nums and a target element target.
 *
 * A target index is an index i such that nums[i] == target.
 *
 * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target
 * indices, return an empty list. The returned list must be sorted in increasing order.
 */
class FindTargetIndicesAfterSortingArray {
    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        var less = 0
        var tar = 0
        for (num in nums) {
            if (num == target) {
                tar++
            } else if (num < target) {
                less++
            }
        }
        val result = mutableListOf<Int>()

        for (i in less until less + tar) {
            result.add(i)
        }
        return result
    }
}