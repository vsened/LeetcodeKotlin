package firstBadVersion

/** First Bad Version
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since
 * each version is developed based on the previous version, all the versions after
 * a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad
 * one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is
 * bad. Implement a function to find the first bad version. You should minimize the
 * number of calls to the API.
 */
class FirstBadVersion {
    /**
     * Using binary search
     */
    fun firstBadVersion(n: Int): Int {
        var start = 0
        var end = n
        while (start <= end) {
            val middle = start + (end - start) / 2
            if (isBadVersion(middle) && !isBadVersion(middle - 1)) {
                return middle
            } else if (isBadVersion(middle) && isBadVersion(middle - 1)) {
                end = middle - 1
            } else {
                start = middle + 1
            }
        }
        return n
    }

    /**
     * Single request.
     */
    fun firstBadVersion2(n: Int): Int {
        var start = 0
        var end = n
        var candidate = end
        while (end > start) {
            val mid = start + (end - start) / 2
            if (isBadVersion(mid)) {
                candidate = mid
                end = mid
            } else {
                start = mid + 1
            }
        }
        return candidate
    }

    private fun isBadVersion(i: Int): Boolean {
        return false
    }
}