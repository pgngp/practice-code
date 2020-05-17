/* https://leetcode.com/problems/binary-search-tree-iterator/ */

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
class BSTIterator {
    private Deque<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        traverseLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pollFirst();
        if (node.right != null) {
            traverseLeft(node.right);   
        }
        
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void traverseLeft(TreeNode node) {
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
