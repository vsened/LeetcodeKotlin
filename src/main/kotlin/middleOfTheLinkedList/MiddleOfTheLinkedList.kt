package middleOfTheLinkedList

import ListNode

/**
 * Middle of the Linked List.
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
class MiddleOfTheLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var current = head
        var middle = head
        while (current != null && current.next != null) {
            current = current.next?.next
            middle = middle?.next
        }
        return middle
    }
}