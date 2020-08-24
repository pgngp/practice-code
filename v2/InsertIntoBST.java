/* https://leetcode.com/problems/insert-into-a-binary-search-tree/ */
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
class InsertIntoBST {
    // iterative
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        
        TreeNode root2 = root;
        while (root2 != null) {
            if (root2.val < node.val) {
                if (root2.right == null) {
                    root2.right = node;
                    break;
                } else {
                    root2 = root2.right;
                }
            } else {
                if (root2.left == null) {
                    root2.left = node;
                    break;
                } else {
                    root2 = root2.left;
                }
            }
        }
        
        return root;
    }
}
