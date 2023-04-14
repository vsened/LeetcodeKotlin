package powerOfTwo
/** Power of Two
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 */
class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        when {
            n == 1 -> return true
            n <= 0 -> return false
        }
        var number = n
        while (number > 1) {
            if (number % 2 != 0) {
                return false
            }
            number /= 2
        }
        return true
    }

}