package romanToInteger
/** Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Given a roman numeral, convert it to an integer.
 */
class RomanToInteger {
    fun romanToInt(s: String): Int {
        val romDigits = hashMapOf<Char, Int>(
                'I' to 1 ,
                'V' to 5 ,
                'X' to 10 ,
                'L' to 50 ,
                'C' to 100 ,
                'D' to 500 ,
                'M' to 1000
        )
        var result = 0
        var index = 0
        while (index < s.length) {
            if (index < s.length - 1
                    && romDigits[s[index+1]]!! > romDigits[s[index]]!!) {
                result += romDigits[s[index+1]]!! - romDigits[s[index]]!!
                index += 2
            } else {
                result += romDigits[s[index]]!!
                index++
            }
        }
        return result
    }
}