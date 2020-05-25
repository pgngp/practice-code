/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        
        if (s.val == t.val && helper(s, t)) {
            return true;
        }
        
        if (isSubtree(s.left, t) || isSubtree(s.right, t)) {
            return true;
        }
        
        return false;
    }
    
    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.val != t.val) {
            return false;
        }
        
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
