package peakIndexInAMountainArray

/** Peak Index in a Mountain Array
 * An array arr a mountain if the following properties hold:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 * You must solve it in O(log(arr.length)) time complexity.
 *
 */
class PeakIndexInAMountainArray {
    /**
     * Use binary search
     */
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var start = 0
        var end = arr.lastIndex
        while (start <= end) {
            val middle = start + (end - start) / 2
            if (arr[middle] > arr[middle-1] && arr[middle] > arr[middle+1]) {
                return middle
            } else if (arr[middle] < arr[middle+1]) {
                start = middle
            } else {
                end = middle
            }
        }
        return 0
    }

    fun peakIndexInMountainArray2(arr: IntArray): Int {
        for (i in 1 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                return i
            }
        }
        return -1
    }
}