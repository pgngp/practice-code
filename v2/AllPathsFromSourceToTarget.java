/* https://leetcode.com/problems/all-paths-from-source-to-target/ */
class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // create nodes
        int n = graph.length;
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new Node(i));
        }
        
        // add children
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodeMap.get(i).addChild(nodeMap.get(graph[i][j]));   
            }
        }
        
        // dfs
        List<List<Integer>> result = new ArrayList<>();
        helper(nodeMap.get(0), result, new ArrayList<>(), n - 1);
        
        return result;
    }
    
    private void helper(Node node, List<List<Integer>> result, List<Integer> list, int lastNodeVal) {
        if (node.val == lastNodeVal) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(node.val);
            result.add(newList);
            return;
        }
        
        list.add(node.val);
        for (Node child : node.children) {
            helper(child, result, list, lastNodeVal);
        }
        list.remove(list.size() - 1);
    }
    
    class Node {
        private int val;
        private List<Node> children;
        
        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
        
        public void addChild(Node node) {
            children.add(node);
        }
    }
}

/*
start from first node going through all the children
at each step add the node ID to a list
when you reach the end, clone the list and add to result
*/
