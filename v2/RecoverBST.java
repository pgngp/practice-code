/* https://leetcode.com/problems/recover-binary-search-tree/ */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RecoverBST {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev.val >= curr.val) {
                    if (first == null) {
                        first = prev;
                        second = curr;
                    } else {
                        second = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode pred = findPredecessor(curr);
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    if (prev != null && prev.val >= curr.val) {
                        if (first == null) {
                            first = prev;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private TreeNode findPredecessor(TreeNode root) {
        TreeNode curr = root.left;
        while (curr.right != null && curr.right != root) {
            curr = curr.right;
        }
        
        return curr;
    }
}
