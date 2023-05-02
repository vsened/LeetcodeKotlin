package sameTree

import TreeNode

/** Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if ((p == null && q != null)
                || (p != null && q == null)) {
            return false
        }
        if (p == null && q == null) {
            return true
        }
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(p!!)
        queue.addLast(q!!)
        while (queue.isNotEmpty()) {
            val first = queue.removeFirst()
            val second = queue.removeFirst()
            if (first.`val` != second.`val`) {
                return false
            }
            if (first.left != null && second.left != null) {
                queue.addLast(first.left!!)
                queue.addLast(second.left!!)
            } else if ((first.left == null && second.left != null)
                    || (first.left != null && second.left == null)) {
                return false
            }
            if (first.right != null && second.right != null) {
                queue.addLast(first.right!!)
                queue.addLast(second.right!!)
            } else if ((first.right == null && second.right != null)
                    || (first.right != null && second.right == null)) {
                return false
            }
        }
        return true
    }

    fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` != q?.`val`) return false
        if (p?.left == null && p?.right == null && q?.left == null && q?.right == null) return true
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

}