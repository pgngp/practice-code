/* https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/ */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class InsertIntoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        // if head is null
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        
        // parse list until we find a node that is less than the curr node
        Node node = head;
        while (node.next != head && node.val <= node.next.val) {
            node = node.next;
        }
        
        // parse list until we find a node greater than new node
        Node lastNode = node;
        while (node.next != lastNode && insertVal > node.next.val) {
            node = node.next;
        }
        
        // if the new node is the biggest
        if (insertVal > node.next.val) {
            node = node.next;
        }
        
        // create new node
        Node newNode = new Node(insertVal, node.next);
        node.next = newNode;
        
        return head;
    }
}
