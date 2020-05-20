/* https://leetcode.com/problems/kth-smallest-element-in-a-bst/ */

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
class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        while (true) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            
            root = stack.pollFirst();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
