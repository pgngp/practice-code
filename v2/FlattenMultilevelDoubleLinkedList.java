/* https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/ */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class FlattenMultilevelDoubleLinkedList {
    public Node flatten(Node head) {
        helper(head);
        
        return head;
    }
    
    private Node helper(Node head) {
        Node prev = head;
        while (head != null) {
            if (head.child != null) {
                Node last = helper(head.child);
                last.next = head.next;
                if (head.next != null) {
                    head.next.prev = last;
                }
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                head = last;
            }
            
            prev = head;
            head = head.next;
        }
        
        return prev;
    }
}
