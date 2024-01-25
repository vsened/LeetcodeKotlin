package containsDuplicate

/**
 * Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element
 * is distinct.
 */
class ContainsDuplicate {
    /**
     * Using HashMap
     */
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
    /**
     * Using HashSet
     */
    fun containsDuplicate2(nums: IntArray): Boolean {
        val set = nums.toHashSet()
        return set.size != nums.size
    }
    /**
     * Using HashSet
     */
    fun containsDuplicate3(nums: IntArray): Boolean {
        val tmp = hashSetOf<Int>()
        for (i in nums) {
            if (i in tmp) return true
            tmp.add(i)
        }
        return false
    }
}