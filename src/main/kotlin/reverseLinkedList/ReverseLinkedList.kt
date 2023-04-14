package reverseLinkedList

import ListNode
/** Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return head
        var prev: ListNode? = null
        var current = head
        var next = head?.next
        while (current?.next != null) {
            current.next = prev
            prev = current
            current = next
            next = next?.next
        }
        current?.next = prev
        return current
    }

    fun reverseList2(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head

        while(curr != null) {
            var tempNxt = curr.next
            curr.next = prev
            prev = curr
            curr = tempNxt
        }
        return prev
    }
}
