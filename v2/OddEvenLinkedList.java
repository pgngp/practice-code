/* https://leetcode.com/problems/odd-even-linked-list/ */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        
        ListNode node = head;
        ListNode head2 = head.next;
        ListNode node2 = head2;
        while (node2 != null && node2.next != null) {
            node.next = node2.next;
            node = node.next;
            node2.next = node.next;
            node2 = node2.next;
        }
        node.next = head2;
        
        return head;
    }
}
