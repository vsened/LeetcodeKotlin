package sqrtX

/** Sqrt(x)
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
class SqrtX {
    fun mySqrt(x: Int): Int {
        if (x <= 1) return x
        var start = 0
        var end = x
        while (start <= end) {
            val middle = (start + end) / 2
            if (middle  == x / middle) {
                return middle
            } else if (middle < x / middle) {
                start = middle + 1
            } else {
                end = middle - 1
            }
        }
        return end
    }

}