package removeAllAdjacentDuplicatesInString

import java.lang.StringBuilder

/** Remove All Adjacent Duplicates In String
 *
 * You are given a string s consisting of lowercase English letters. A duplicate removal
 * consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be
 * proven that the answer is unique.
 */
class RemoveAllAdjacentDuplicatesInString {
    /** Using stack
     */
    fun removeDuplicates(s: String): String {
        val stack = ArrayDeque<Char>()
        for (letter in s) {
            if (stack.isEmpty()) {
                stack.addLast(letter)
            } else {
                val top = stack.last()
                if (top == letter) {
                    stack.removeLast()
                } else {
                    stack.addLast(letter)
                }
            }
        }
        return stack.joinToString()
    }
    /**
     * Using StringBuilder
     */
    fun removeDuplicates2(s: String): String {
        val stack = StringBuilder()
        for (letter in s) {
            if (stack.isEmpty()) {
                stack.append(letter)
            } else {
                if (stack[stack.lastIndex] == letter) {
                    stack.setLength(stack.length - 1)
                } else {
                    stack.append(letter)
                }
            }
        }
        return stack.toString()
    }
}