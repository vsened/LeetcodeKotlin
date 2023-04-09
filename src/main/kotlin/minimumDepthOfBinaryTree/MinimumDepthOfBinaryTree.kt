package minimumDepthOfBinaryTree

import TreeNode

/** Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root
 * node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 */
class MinimumDepthOfBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val depths = ArrayList<Int>()
        checkTreeNode(root!!, depths, 1)
        return depths.min()
    }

    private fun checkTreeNode(node: TreeNode, depths: ArrayList<Int>, depth: Int) {
        if (node.right == null && node.left == null) {
            depths.add(depth)
        }
        if (node.right != null) {
            checkTreeNode(node.right!!, depths, depth + 1)
        }
        if (node.left != null) {
            checkTreeNode(node.left!!, depths, depth + 1)
        }
    }
}