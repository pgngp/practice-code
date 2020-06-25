/* https://leetcode.com/problems/deepest-leaves-sum/ */
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
class DeepestLeavesSum {
    private int sum;
    private int maxDepth;
    
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        sum = 0;
        maxDepth = 0;
        
        helper(root, 0);

        return sum;
    }
    
    private void helper(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }

        currDepth++;
        if (root.left == null && root.right == null) {
            if (maxDepth < currDepth) {
                maxDepth = currDepth;
                sum = root.val;
            } else if (maxDepth == currDepth) {
                sum += root.val;
            }
        } else {
            helper(root.left, currDepth);
            helper(root.right, currDepth);
        }
    }
}
