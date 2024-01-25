package averageOfLevelsInBinaryTree

import TreeNode
import java.util.*
import kotlin.collections.ArrayList

class AverageOfLevelsInBinaryTree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = mutableListOf<Double>()
        val queue = LinkedList<TreeNode>()

        queue.offer(root)

        while(queue.isNotEmpty()) {
            var levelSum = 0.0
            var levelSize = queue.size

            repeat(queue.size) {
                val currentNode = queue.poll()
                levelSum += currentNode.`val`
                if (currentNode.left != null) queue.offer(currentNode.left)
                if (currentNode.right != null) queue.offer(currentNode.right)
            }
            result.add(levelSum / levelSize)
        }
        return result.toDoubleArray()
    }

}