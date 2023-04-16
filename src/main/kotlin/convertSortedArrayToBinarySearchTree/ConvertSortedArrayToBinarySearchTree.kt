package convertSortedArrayToBinarySearchTree

import TreeNode

class ConvertSortedArrayToBinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        when (nums.size) {
            1 -> return TreeNode(nums[0])
            0 -> return null
        }
        val middle = nums.lastIndex / 2
        val root = TreeNode(nums[middle])
        addToBST(root, nums, 0, middle - 1)
        addToBST(root, nums, middle + 1, nums.lastIndex)
        return root
    }

    private fun addToBST(node: TreeNode, nums: IntArray, start: Int, end: Int) {
        if (start >= end) {
            add(node, nums, start)
            return
        }
        val middle = start + (end - start) / 2
        add(node, nums, middle)
        addToBST(node, nums, start, middle - 1)
        addToBST(node, nums, middle + 1, end)
    }

    private fun add(node: TreeNode, nums: IntArray, index: Int) {
        if (node.`val` == nums[index]) {
            return
        } else if(node.`val` > nums[index]) {
            if (node.left != null) {
                add(node.left!!, nums, index)
            } else {
                node.left = TreeNode(nums[index])
            }
        } else {
            if (node.right != null) {
                add(node.right!!, nums, index)
            } else {
                node.right = TreeNode(nums[index])
            }
        }
        return
    }

}