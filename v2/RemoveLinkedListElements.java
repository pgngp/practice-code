/* https://leetcode.com/problems/remove-linked-list-elements/ */
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
class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode node = head;
        while (node != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        
        return head;
    }
}
