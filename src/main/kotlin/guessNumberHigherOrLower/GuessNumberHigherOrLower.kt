package guessNumberHigherOrLower
/** Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
class GuessNumberHigherOrLower {
    fun guessNumber(n:Int):Int {
        var start = 0
        var end = n
        while (start < end) {
            val middle = start + (end - start) / 2
            when (guess(middle)) {
                -1 -> {
                    end = middle - 1
                }
                1 -> {
                    start = middle + 1
                }
                else -> {
                    return middle
                }
            }
        }
        return end
    }

    fun guess(num:Int) = 0
}