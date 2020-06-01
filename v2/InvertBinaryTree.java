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
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        dfs(root);
        
        return root;
    }
    
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // left
        dfs(root.left);
        
        // right
        dfs(root.right);
        
        // current
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
