/* https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ */
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
class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {        
        // map for node -> HD
        Map<TreeNode, Integer> nodeHorDistMap = new HashMap<>();
        nodeHorDistMap.put(root, 0);
        
        // priority queue
        PriorityQueue<VOTNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.horDist != b.horDist) {
                return a.horDist - b.horDist;
            } else if (a.verDist != b.verDist) {
                return a.verDist - b.verDist;
            } else {
                return a.node.val - b.node.val;
            }
        });
        
        // queue for level-order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        pq.offer(new VOTNode(0, 0, root));
        
        // calculate HD for each node in the tree
        int verDist = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> newQueue = new ArrayDeque<>();
            
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                int horDist = nodeHorDistMap.get(node);

                if (node.left != null) {
                    newQueue.offerLast(node.left);

                    int currHorDist = horDist - 1;
                    nodeHorDistMap.put(node.left, currHorDist);

                    pq.offer(new VOTNode(currHorDist, verDist, node.left));
                }

                if (node.right != null) {
                    newQueue.offerLast(node.right);

                    int currHorDist = horDist + 1;
                    nodeHorDistMap.put(node.right, currHorDist);
                    
                    pq.offer(new VOTNode(currHorDist, verDist, node.right));
                }
            }
            
            queue = newQueue;
            verDist++;
        }
        
        // go through nodes in pq
        int prevHorDist = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            VOTNode votNode = pq.poll();
            if (votNode.horDist != prevHorDist) {
                prevHorDist = votNode.horDist;
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(votNode.node.val);
        }
        
        return result;
    }
    
    class VOTNode {
        private int horDist;
        private int verDist;
        private TreeNode node;
        
        public VOTNode(int horDist, int verDist, TreeNode node) {
            this.horDist = horDist;
            this.verDist = verDist;
            this.node = node;
        }
    }
}
