/* https://leetcode.com/problems/binary-tree-right-side-view/ */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Deque<TreeNode> q = new ArrayDeque<>();
        int nextSize = 0, currSize = 1;
        q.offerLast(root);
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            
            if (node.left != null) {
                q.offerLast(node.left);
                nextSize++;
            }
            
            if (node.right != null) {
                q.offerLast(node.right);
                nextSize++;
            }
            
            currSize--;
            if (currSize == 0) {
                result.add(node.val);
                currSize = nextSize;
                nextSize = 0;
            }
        }
        
        return result;
    }
}
