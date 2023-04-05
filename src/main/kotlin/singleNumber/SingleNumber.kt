package singleNumber

/** Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 */

class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        val numbers = mutableMapOf<Int, Int>()
        for (num in nums) {
            if (numbers.containsKey(num)) {
                numbers[num] = 2
            } else {
                numbers[num] = 1
            }
        }
        for (key in numbers.keys) {
            if (numbers[key] == 1) {
                return key
            }
        }
        return 0
    }

    fun singleNumberXor(nums: IntArray): Int {
        var a = 0
        nums.forEach {
            a = a.xor(it)
        }
        return a
    }
}