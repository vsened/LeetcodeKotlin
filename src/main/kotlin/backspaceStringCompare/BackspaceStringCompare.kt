package backspaceStringCompare
/** Backspace String Compare
 *
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 */

class BackspaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        val stackS = createString(s)
        val stackT = createString(t)
        return stackS == stackT
    }
    fun backspaceCompare2(s: String, t: String): Boolean {
        val stackS = createStack(s)
        val stackT = createStack(t)
        if (stackS.size != stackT.size) {
            return false
        } else {
            while (stackS.size > 0) {
                if (stackS.removeLast() != stackT.removeLast()) {
                    return false
                }
            }
        }
        return true
    }

    fun backspaceCompare3(s: String, t: String): Boolean {

        var i = s.lastIndex
        var j = t.lastIndex
        var back: Int

        while (true) {
            back = 0
            while (i >= 0 && (back > 0 || s[i] == '#')) {
                back += if (s[i] == '#') 1 else -1
                i--
            }

            back = 0
            while (j >= 0 && (back > 0 || t[j] == '#')) {
                back += if (t[j] == '#') 1 else -1
                j--
            }

            if (i >= 0 && j >= 0 && s[i] == t[j]) {
                i--
                j--
            } else {
                break
            }

        }

        return i == -1 && j == -1

    }

    private fun createStack(string: String): ArrayDeque<Char> {
        val result = ArrayDeque<Char>()
        for (char in string) {
            if (char == '#') {
                if (!result.isEmpty()) {
                    result.removeLast()
                }
            } else {
                result.addLast(char)
            }
        }
        return result
    }

    private fun createString(input: String): String {
        val stack = createStack(input)
        return stack.joinToString("")
    }
}