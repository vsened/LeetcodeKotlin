package containsDuplicate

/**
 * Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element
 * is distinct.
 */
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashMap = mutableMapOf<Int, Int>()
        for (i in nums){
            if(hashMap.containsKey(i))
                return true
            else
                hashMap[i] = 1
        }
        return false
    }
}