package twoSum

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numbers = HashMap<Int, Int>()
        nums.forEachIndexed { index, number ->
            numbers[number] = index
        }
        for (number in numbers.keys) {
            if (numbers.containsKey(target - number))
                return intArrayOf(
                    numbers.getOrDefault(number, 0),
                    numbers.getOrDefault(target - number, 0)
                )
        }
        return intArrayOf()
    }
}