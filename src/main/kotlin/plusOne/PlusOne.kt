package plusOne
/**
 * Plus One
 *
 * You are given a large integer represented as an integer array digits, where each
 * digits[i] is the ith digit of the integer. The digits are ordered from most
 * significant to least significant in left-to-right order. The large integer does
 * not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.last() != 9) {
            digits[digits.lastIndex]++
            return digits
        } else {
            for(index in digits.lastIndex downTo 0) {
                if (index == 0 && digits[index] + 1 == 10) {
                    digits[index] = 0
                    val result = digits.toMutableList()
                    result.add(0, 1)
                    return result.toIntArray()
                } else if (digits[index] + 1 == 10){
                    digits[index] = 0
                } else {
                    digits[index]++
                    return digits
                }
            }
            return digits
        }
    }

    fun plusOne2(digits: IntArray): IntArray {
        var carryOver = 1
        for (i in digits.size - 1 downTo 0) {
            digits[i] += carryOver
            carryOver = digits[i] / 10
            if (carryOver == 0) return digits
            digits[i] %= 10
        }
        return intArrayOf(carryOver, *digits)
    }
}