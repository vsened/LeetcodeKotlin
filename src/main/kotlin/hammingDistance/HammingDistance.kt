package hammingDistance
/** Hamming Distance
 *
 *  The Hamming distance between two integers is the number of positions at which
 *  the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 */
class HammingDistance {
    fun hammingDistance(x: Int, y: Int): Int {
        var count = 0
        var xString = x.toString(2)
        var yString = y.toString(2)
        if (xString.length > yString.length) {
            yString = yString.padStart(xString.length, '0')
        } else if (xString.length < yString.length) {
            xString = xString.padStart(yString.length, '0')
        }
        for (i in xString.indices) {
            if (xString[i] != yString[i]) {
                count++
            }
        }
        return count
    }

    fun hammingDistance2(x: Int, y: Int): Int {
        var ans = 0;
        val parse = Integer.toBinaryString(x xor y);
        for (i in 0..parse.lastIndex) {
            if(parse[i] == '1') ans++
        }
        return ans
    }
}