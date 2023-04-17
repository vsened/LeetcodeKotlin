package flippingAnImage
/** Flipping an Image
 *
 * Given an n x n binary matrix image, flip the image horizontally, then invert it,
 * and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 *
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 *
 * For example, inverting [0,1,1] results in [1,0,0].
 */
class FlippingAnImage {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (row in image.indices) {
            val tmp = IntArray(image[row].size)
            for (cell in image[row].indices) {
                tmp[image[row].lastIndex - cell] = if (image[row][cell] == 0) 1 else 0
            }
            result.add(tmp)
        }
        return result.toTypedArray()
    }
}