package addDigits
/**
 * Add Digits
 *
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * */
class AddDigits {
    /**
     * Using recursion
     * */
    fun addDigits(num: Int): Int {
        var sum = 0
        var currentNum = num
        while (currentNum > 0) {
            sum += currentNum % 10
            currentNum /= 10
        }
        if (sum < 10) {
            return sum
        } else {
            return addDigits(sum)
        }
    }

    fun addDigits2(num: Int): Int {
        if (num < 10)
            return num;
        return addDigits2(num % 10 + num / 10);
    }
}