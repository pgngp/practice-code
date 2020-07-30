/* https://leetcode.com/problems/range-sum-of-bst/ */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }   
        
        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }
        
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }
}
