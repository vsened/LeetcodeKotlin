package summaryRanges

/** Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is,
 * each element of nums is covered by exactly one of the ranges, and there is no integer x such that x
 * is in one of the ranges but not in nums.
 */
class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        val ranges = mutableListOf<String>()
        var index = 0
        while (index < nums.size) {
            var s = nums[index]
            while (index < nums.size) {
                if (index < nums.size - 1 && nums[index] + 1 != nums[index+1]) {
                    if (s == nums[index]) {
                        ranges.add("${nums[index]}")
                    } else {
                        ranges.add("$s->${nums[index]}")
                    }
                    break
                } else if (index == nums.size - 1) {
                    if (s == nums[index]) {
                        ranges.add("${nums[index]}")
                    } else {
                        ranges.add("$s->${nums[index]}")
                    }
                    break
                } else {
                    index++
                }
            }
            index++
        }
        return ranges
    }


}