package sumOfLeftLeaves
import TreeNode
/** Sum of Left Leaves
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 */
class SumOfLeftLeaves {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        var sum = 0
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node.left != null) {
                if (node.left?.left == null && node.left?.right == null) {
                    sum += node.left?.`val`!!
                } else {
                    queue.addLast(node.left!!)
                }
            }
            if (node.right != null) {
                queue.addLast(node.right!!)
            }
        }
        return sum
    }
}