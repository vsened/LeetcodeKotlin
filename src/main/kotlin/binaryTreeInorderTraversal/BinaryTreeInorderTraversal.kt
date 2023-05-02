package binaryTreeInorderTraversal
import TreeNode
/** Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        helper(root, result)
        return result
    }

    private fun helper(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) {
            return;
        }
        helper(node?.left, list)
        list.add(node.`val`)
        helper(node?.right, list)
    }
}