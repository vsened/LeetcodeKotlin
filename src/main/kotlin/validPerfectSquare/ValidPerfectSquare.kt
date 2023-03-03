package validPerfectSquare

/**
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer. In other words, it is
 * the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 */

class ValidPerfectSquare {
    fun isPerfectSquare(num: Int): Boolean {
        var number: Long = 0
        val target = num.toLong()
        while (number * number <=  target) {
            if (number * number == target) return true
            number++
        }
        return false
    }
    /**
     * Binary search
     */
    fun isPerfectSquare2(num: Int): Boolean {
        if (num == 1)
            return true;
        var start: Long = 0
        val target = num.toLong()
        var end: Long = target / 2
        while (start <= end) {
            val middle = (end + start) / 2
            if (middle * middle == target) {
                return true
            } else if (middle * middle < target){
                start = middle + 1
            } else {
                end = middle - 1
            }
        }
        return false
    }
}