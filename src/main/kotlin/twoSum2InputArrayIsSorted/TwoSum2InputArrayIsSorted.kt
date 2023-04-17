package twoSum2InputArrayIsSorted
/** Two Sum II - Input Array Is Sorted
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers
 * be numbers at index1 and numbers at index2 where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array
 * [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same
 * element twice.
 *
 * Your solution must use only constant extra space.
 */
class TwoSum2InputArrayIsSorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (index in numbers.indices) {
            for (checkIndx in index+1..numbers.lastIndex) {
                if (numbers[index] + numbers[checkIndx] == target) {
                    return intArrayOf(index+1, checkIndx+1)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var min = 0
        var max = numbers.size-1
        while(min<max) {
            if(numbers[min]+numbers[max]==target) return intArrayOf(min+1,max+1)
            if(numbers[min]+numbers[max]>target) {
                max--
            }
            if(numbers[min]+numbers[max]<target) {
                min++
            }
        }
        return intArrayOf()
    }
}