package nthTribonacciNumber
/**
 * N-th Tribonacci Number
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 */
class NthTribonacciNumber {
    fun tribonacci(n: Int): Int {
        if (n == 0) {
            return n
        } else if (n <= 2) {
            return 1
        }
        val tribonacciSequence = mutableListOf<Int>(0, 1, 1)
        for (index in 3..n) {
            tribonacciSequence.add(tribonacciSequence[index - 3] + tribonacciSequence[index - 2] + tribonacciSequence[index - 1])
        }
        return tribonacciSequence.last()
    }

    fun tribonacci2(n: Int): Int {
        if (n == 0) {
            return n
        } else if (n <= 2) {
            return 1
        }
        var a = 0
        var b = 1
        var c = 1
        var number = 3
        while (number <= n) {
            val temp = a
            a = b
            b = c
            c = temp + b + a
            number++
        }
        return c
    }

    fun tribonacci3(n: Int): Int {
        val ans = IntArray(if (n < 3) 3 else n+1)

        ans[0] = 0
        ans[1] = 1
        ans[2] = 1
        for (i in 3..n) {
            ans[i] = ans[i-1] + ans[i-2] + ans[i-3]
        }
        return ans[n]
    }
}