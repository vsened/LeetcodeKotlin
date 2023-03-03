package moveZeroes
/**
 * Move Zeroes.
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var digitCursor = 0
        var zeroCursor = 0
        for (index in nums.indices) {
            if (nums[index] == 0) {
                zeroCursor = index
                digitCursor = index + 1
                while (nums[digitCursor] == 0 && digitCursor < nums.size) {
                    digitCursor++
                }
                nums[zeroCursor] = nums[digitCursor]
                nums[digitCursor] = 0
            }
        }
    }

    fun moveZeroes2(nums: IntArray): Unit {

        var numOfZero = 0
        for(i in nums.indices){
            if(nums[i] == 0) numOfZero++
            else if(numOfZero > 0){
                val temp = nums[i]
                nums[i] = 0
                nums[i-numOfZero] = temp
            }
        }
    }
}