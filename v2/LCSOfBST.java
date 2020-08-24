/* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LCSOfBST {
    // iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        while (root.val < p.val || root.val > q.val) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        
        return root;
    }
    
    // recursive
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        } else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
