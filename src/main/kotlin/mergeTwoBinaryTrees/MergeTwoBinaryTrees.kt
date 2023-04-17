package mergeTwoBinaryTrees

import TreeNode
/** Merge Two Binary Trees
 *
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees
 * are overlapped while the others are not. You need to merge the two trees into a new
 * binary tree. The merge rule is that if two nodes overlap, then sum node values up as
 * the new value of the merged node. Otherwise, the NOT null node will be used as the node
 * of the new tree.
 *
 * Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 */
class MergeTwoBinaryTrees {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return helper(root1, root2)
    }

    private fun helper(node1: TreeNode?, node2: TreeNode?): TreeNode? {
        val node = if (node1 != null && node2 != null) {
            TreeNode(node1.`val`!! + node2.`val`!!)
        } else if (node1 != null && node2 == null) {
            TreeNode(node1.`val`)
        } else if (node2 != null) {
            TreeNode(node2.`val`)
        } else {
            null
        }
        node?.left = helper(node1?.left, node2?.left)
        node?.right = helper(node1?.right, node2?.right)
        return node
    }
}