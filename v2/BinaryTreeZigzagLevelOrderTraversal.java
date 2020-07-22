/* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ */
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
class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        boolean fifo = true;
        while (!deque.isEmpty()) {
            Deque<TreeNode> newDeque = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                
                if (node.left != null) {
                    newDeque.offerLast(node.left);
                }
                
                if (node.right != null) {
                    newDeque.offerLast(node.right);
                }
            }
            
            if (!fifo) {
                fifo = true;
                Collections.reverse(list);
            } else {
                fifo = false;
            }
            
            result.add(list);
            deque = newDeque;
        }
        
        return result;
    }
}
