package majorityElement
/** Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val elems = HashMap<Int, Int>()
        for (num in nums) {
            elems[num] = elems.getOrDefault(num, 0) + 1
        }
        var max = 0
        var elem = 0
        for (key in elems.keys) {
            if (max < elems[key]!!) {
                max = elems[key]!!
                elem = key
            }
        }
        return elem
    }

    fun majorityElement2(nums: IntArray): Int {

        var majorityElement = nums[0]

        var count = 0;
        for(i in nums.indices){
            if(count==0){
                count++;
                majorityElement = nums[i];
            }else if(majorityElement == nums[i]){
                count++;
            }else count--;

        }
        return majorityElement;
    }
}