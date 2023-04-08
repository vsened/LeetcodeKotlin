package powerOfFour
/** Power of Four
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 */
class PowerOfFour {
    /**
     * Using math
     */
    fun isPowerOfFour(n: Int): Boolean {
        if (n == 0) {
            return false
        }
        var num = n
        while (num != 1) {
            if (num % 4 != 0) {
                return false
            }
            num /= 4
        }
        return true
    }

    /**
     * Using string
     */
    fun isPowerOfFour2(n: Int): Boolean {
        return n.toString(2).replace("0", "").length == 1
                && n.toString(2).length % 2 != 0
    }
}
