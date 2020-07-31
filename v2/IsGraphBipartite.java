/* https://leetcode.com/problems/is-graph-bipartite/ */
class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        // create nodes (time: O(V); space: O(V))
        int n = graph.length;
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodeMap.put(i, node);
        }
        
        // add neighbors (time: (V + E); space: O(E))
        for (int i = 0; i < n; i++) {
            Node node1 = nodeMap.get(i);
            for (int j = 0; j < graph[i].length; j++) {
                Node node2 = nodeMap.get(graph[i][j]);
                node1.addNeighbor(node2);
                node2.addNeighbor(node1);
            }
        }
        
        // dfs (time: O(V + E); space: O(V + E))
        for (int i = 0; i < n; i++) {
            Node node = nodeMap.get(i);
            if (node.set != 0) {
                continue;
            }
            node.set = 1;
            if (!dfs(node)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Node node) {
        for (Node neighbor : node.neighbors) {
            if (neighbor.set == 0) {
                neighbor.set = node.set == 1 ? 2 : 1;
            } else if (neighbor.set == node.set) {
                return false;
            } else {
                continue;
            }
            
            if (!dfs(neighbor)) {
                return false;
            }
        }
        
        return true;
    }
    
    class Node {
        private int val;
        private int set;
        private List<Node> neighbors;
        
        public Node(int val) {
            this.val = val;
            this.set = 0;
            this.neighbors = new ArrayList<>();
        }
        
        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }
}
