package pascalsTriangle

/** Pascal's Triangle
 *  Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it
 *
 */
class PascalsTriangle {

    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (row in 0 until numRows) {
            val listRow = Array(row + 1) { 1 }
            for (index in listRow.indices) {
                if (index != 0 && index != listRow.lastIndex) {
                    listRow[index] = result[row - 1][index - 1] + result[row - 1][index]
                }
            }
            result.add(listRow.toList())
        }
        return result.toList()
    }

    fun generate2(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        repeat(numRows) { depth ->
            result.add(MutableList(depth + 1) { i ->
                when (i) {
                    0, depth -> 1
                    else -> result[depth - 1][i - 1] + result[depth - 1][i]
                }
            })
        }
        return result
    }
}