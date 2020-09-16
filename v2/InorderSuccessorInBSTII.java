/* https://leetcode.com/problems/inorder-successor-in-bst-ii/ */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class InorderSuccessorInBSTII {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (node.parent == null) {
            return null;
        } else if (node.parent.left == node) {
            return node.parent;
        } else {
            while (node.parent != null && node != node.parent.left) {
                node = node.parent;
            }
            return node.parent;
        }
    }
}
