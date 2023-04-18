package validMountainArray

/** Valid Mountain Array
 *
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 */
class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) {
            return false
        }
        var min = 0
        while(min != arr.lastIndex) {
            if (arr[min] >= arr[min+1]){
                break;
            }
            min++
        }
        var max = arr.lastIndex
        while(max != 0) {
            if (arr[max] >= arr[max-1]){
                break;
            }
            max++
        }
        return min == max && min != 0 && max != arr.lastIndex
    }
}