package binarySearch
/**
 * Binary Search
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise,
 * return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val middle = start + (end - start) / 2
            if (nums[middle] == target){
                return middle
            } else if (nums[middle] < target) {
                start = middle + 1
            } else {
                end = middle - 1
            }
        }
        return -1
    }
}