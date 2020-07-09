/* https://leetcode.com/problems/maximum-width-of-binary-tree/ */
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
class MaxWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Deque<LevelNode> q = new ArrayDeque<>();
        q.offerLast(new LevelNode(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            int start = q.peekFirst().index;
            maxWidth = Math.max(maxWidth, q.peekLast().index - q.peekFirst().index + 1);
            for (int i = 0; i < qSize; i++) {
                LevelNode levelNode = q.pollFirst();
                TreeNode treeNode = levelNode.treeNode;
                
                if (treeNode.left != null) {
                    q.offerLast(new LevelNode(treeNode.left, 2 * levelNode.index + 1 - start));
                }
                
                if (treeNode.right != null) {
                    q.offerLast(new LevelNode(treeNode.right, 2 * levelNode.index + 2 - start));
                }
            }
        }
        
        return maxWidth;
    }
    
    class LevelNode {
        private TreeNode treeNode;
        private int index;
        
        public LevelNode(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }
}
