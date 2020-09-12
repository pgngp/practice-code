/* https://leetcode.com/problems/binary-tree-vertical-order-traversal/ */
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
class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // check input
        if (root == null) {
            return new ArrayList<>();
        }
        
        // create pq
        PriorityQueue<VOTNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            } else if (a.y != b.y) {
                return a.y - b.y;
            } else {
                return a.idx - b.idx;
            }
        });
        
        // bfs
        Deque<VOTNode> q = new ArrayDeque<>();
        q.offerLast(new VOTNode(root, 0, 0, 0));
        int min = 0, max = 0, idx = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                VOTNode votNode = q.pollFirst();
                pq.offer(votNode);
                TreeNode treeNode = votNode.node;
                
                if (treeNode.left != null) {
                    q.offerLast(new VOTNode(treeNode.left, votNode.x - 1, votNode.y + 1, idx++));
                    min = Math.min(min, votNode.x - 1);
                }
                
                if (treeNode.right != null) {
                    q.offerLast(new VOTNode(treeNode.right, votNode.x + 1, votNode.y + 1, idx++));
                    max = Math.max(max, votNode.x + 1);
                }
            }
        }
        
        // result output
        List<List<Integer>> result = new ArrayList<>();
        int numLevels = max - min + 1;
        for (int i = 0; i < numLevels; i++) {
            result.add(new ArrayList<>());
        }
        while (!pq.isEmpty()) {
            VOTNode votNode = pq.poll();
            result.get(votNode.x + Math.abs(min)).add(votNode.node.val);
        }
        
        return result;
    }
    
    class VOTNode {
        private TreeNode node;
        private int x;
        private int y;
        private int idx;
        
        public VOTNode(TreeNode node, int x, int y, int idx) {
            this.node = node;
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
