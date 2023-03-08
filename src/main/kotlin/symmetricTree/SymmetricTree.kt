package symmetricTree

import TreeNode
import java.util.ArrayDeque

/**
 * Symmetric Tree.
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root!!.left == null || root.right == null) {
            return root.right == root.left
        }
        val deque = ArrayDeque<TreeNode?>()
        root.left?.let { deque.add(it) }
        root.right?.let { deque.add(it) }
        while (deque.isNotEmpty()) {
            val left =  deque.pollFirst()
            val right = deque.pollFirst()
            if (left!!.`val` != right!!.`val`) {
                return false
            }
            if (left.left != null && right.right != null) {
                left.left?.let { deque.add(it) }
                right.right?.let { deque.add(it) }
            } else if (left.left == null && right.right != null
                || left.left != null && right.right == null) {
                return false
            }
            if (left.right != null && right.left != null) {
                left.right?.let { deque.add(it) }
                right.left?.let { deque.add(it) }
            } else if (left.right == null && right.left != null
                || left.right != null && right.left == null) {
                return false
            }
        }
        return true
    }

}