package assignCookies
/** Assign Cookies
 *
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at
 * most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
 * will be content. Your goal is to maximize the number of your content children and output the maximum number.
 */
class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        val greed = g.toMutableList()
        val cookies = s.toMutableList()
        greed.sort()
        cookies.sort()
        var result = 0
        for (child in greed) {
            for (i in cookies.indices) {
                if (child <= cookies[i]) {
                    result++
                    cookies.removeAt(i)
                    break
                }
            }
        }
        return result
    }

    fun findContentChildren2(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var content = 0
        var kid = 0
        var cookie = 0
        while (kid < g.size && cookie < s.size) {
            if (g[kid] <= s[cookie]) {
                content++
                kid++
                cookie++
            } else {
                cookie++
            }
        }
        return content
    }
}