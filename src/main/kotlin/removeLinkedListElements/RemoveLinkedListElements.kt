package removeLinkedListElements

import ListNode

/**
 * Remove Linked List Elements
 *
 * Given the head of a linked list and an integer val, remove all
 * the nodes of the linked list that has Node.val == val, and return
 * the new head.
 *
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null)
            return head
        val newHead: ListNode? = ListNode(0)
        newHead?.next = head
        var currentNode: ListNode? = newHead
        while (currentNode?.next != null){
            if (currentNode.next?.`val` == `val`){
                currentNode.next = currentNode.next?.next
                continue
            }
            currentNode = currentNode.next
        }
        return newHead?.next
    }
}