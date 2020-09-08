/* https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/ */
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
class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum) {
        sum = 2 * sum + root.val;
        
        if (root.left != null && root.right != null) {
            return helper(root.left, sum) + helper(root.right, sum);
        } else if (root.left != null) {
            return helper(root.left, sum);
        } else if (root.right != null) {
            return helper(root.right, sum);
        } else {
            return sum;
        }
    }
}
