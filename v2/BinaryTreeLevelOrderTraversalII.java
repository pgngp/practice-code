/* https://leetcode.com/problems/binary-tree-level-order-traversal-ii/ */
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
class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            Deque<TreeNode> newQueue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                
                if (node.left != null) {
                    newQueue.offerLast(node.left);   
                }

                if (node.right != null) {
                    newQueue.offerLast(node.right);
                }
            }
            queue = newQueue;
            result.add(list);
        }
        Collections.reverse(result);
        
        return result;
    }
}
