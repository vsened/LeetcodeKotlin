package checkIfNAndItsDoubleExist
/**
 * Check If N and Its Double Exist.
 *
 * Given an array arr of integers, check if there exist two indices i and j such that :
 *
 * i != j
 *
 * 0 <= i, j < arr.length
 *
 * arr[i] == 2 * arr[j]
 */
class CheckIfNAndItsDoubleExist {
    fun checkIfExist(arr: IntArray): Boolean {
        val numbers = HashMap<Int, Int>()
        for (index in arr.indices) {
            numbers[arr[index]] = index
        }
        for (index in arr.indices) {
            if (numbers.containsKey(arr[index] * 2)
                && index != numbers[arr[index] * 2]) {
                return true
            }
        }
        return false
    }
}