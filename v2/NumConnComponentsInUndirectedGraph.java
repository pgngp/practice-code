/* https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/ */
class NumConnComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        // create node map
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new Node(i));
        }
        
        // add edges
        for (int[] edge : edges) {
            Node node1 = nodeMap.get(edge[0]);
            Node node2 = nodeMap.get(edge[1]);
            node1.addNeighbor(node2);
            node2.addNeighbor(node1);
        }
        
        // parse graph
        Set<Node> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Node node = nodeMap.get(i);
            if (visited.contains(node)) {
                continue;
            }
            dfs(node, visited);
            count++;
        }
        
        return count;
    }
    
    private void dfs(Node node, Set<Node> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        
        for (Node neighbor : node.neighbors) {
            dfs(neighbor, visited);
        }
    }
    
    class Node {
        private int id;
        private List<Node> neighbors;
        
        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
        
        public void addNeighbor(Node node) {
            neighbors.add(node);
        }
    }
}
