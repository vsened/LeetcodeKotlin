package binaryTreePaths
import TreeNode
/** Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 */
class BinaryTreePaths {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val paths = ArrayList<String>()
        getPaths(root, paths)
        return paths
    }

    private fun getPaths(root: TreeNode?, paths: ArrayList<String>) {
        if (root == null) {
            return
        }
        checkPaths(root, paths, "")
    }

    private fun checkPaths(node: TreeNode, paths: ArrayList<String>, path: String) {
        if (node?.left == null && node?.right == null) {
            paths.add("$path${node.`val`}")
            return
        }
        if (node?.left != null) {
            checkPaths(node.left!!, paths, "$path${node.`val`}->")
        }
        if (node?.right != null) {
            checkPaths(node.right!!, paths, "$path${node.`val`}->")
        }
    }
}