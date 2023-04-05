package reverseString
/** Reverse String
 * Write a function that reverses a string. The input string is given as an array
 * of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
class ReverseString {
    fun reverseString(s: CharArray): Unit {
        for (index in 0 until s.size/2) {
            val temp = s[index]
            s[index] = s[s.lastIndex - index]
            s[s.lastIndex - index] = temp
        }
    }
}