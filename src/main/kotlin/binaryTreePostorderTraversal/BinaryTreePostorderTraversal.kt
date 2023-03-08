package binaryTreePostorderTraversal

import TreeNode

/**
 * Binary Tree Postorder Traversal.
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
class BinaryTreePostorderTraversal {
    fun postorderTraversal (root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        postorderTraversalRecursion(root, result)
        return result
    }
    private fun postorderTraversalRecursion(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        postorderTraversalRecursion(root.left, list)
        postorderTraversalRecursion(root.right, list)
        list.add(root.`val`)
    }
}