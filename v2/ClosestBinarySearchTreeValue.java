/* https://leetcode.com/problems/closest-binary-search-tree-value/ */
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
class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double shortestDiff = Double.MAX_VALUE;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
            
            double diff = ((double) root.val) - target;
            if (shortestDiff > Math.abs(diff)) {
                shortestDiff = Math.abs(diff);
                closest = root.val;
            }
            
            root = diff < 0.0 ? root.right : root.left;
        }
        
        return closest;
    }
}
