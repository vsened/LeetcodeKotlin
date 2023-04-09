package canPlaceFlowers
/** Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1
 * means not empty, and an integer n, return true if n new flowers can be planted in
 * the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 */
class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var total = 0
        for (i in flowerbed.indices) {
            val canPlant = if (((if (i - 1 < 0) 0 else flowerbed[i - 1]) + flowerbed[i] +
                    (if (i + 1 > flowerbed.lastIndex) 0 else flowerbed[i + 1])) == 0) 1 else 0
            if (canPlant == 1) {
                flowerbed[i] = 1
                total++
            }
        }
        return total >= n
    }

}