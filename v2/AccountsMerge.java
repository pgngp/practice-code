/* https://leetcode.com/problems/accounts-merge/ */
class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // create nodes (time: O(mn); space: O(mn); m is num accounts and n is num emails in each account)
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                nodeMap.putIfAbsent(email, new Node(email));
            }
        }
        
        // create edges between nodes (time: O(mn); space: O(mn))
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).size() < 3) {
                continue;
            }
            
            Node node1 = nodeMap.get(accounts.get(i).get(1));
            for (int j = 2; j < accounts.get(i).size(); j++) {
                Node node2 = nodeMap.get(accounts.get(i).get(j));
                node1.addNeighbor(node2);
                node2.addNeighbor(node1);
            }
        }
        
        // dfs (time: O(mn log mn); space: O(mn))
        List<List<String>> result = new ArrayList<>();
        Set<Node> seen = new HashSet<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = new ArrayList<>();
            list.add("");
            for (int j = 1; j < accounts.get(i).size(); j++) {
                Node node = nodeMap.get(accounts.get(i).get(j));
                helper(node, result, seen, list);     
            }
            
            if (list.size() < 2) {
                continue;
            }
            
            Collections.sort(list);
            list.set(0, accounts.get(i).get(0));
            result.add(list);
        }
        
        return result;
    }
    
    private void helper(Node node, List<List<String>> result, Set<Node> seen, List<String> list) {
        if (seen.contains(node)) {
            return;
        }
        
        seen.add(node);
        list.add(node.email);
        for (Node neighbor : node.neighbors) {
            helper(neighbor, result, seen, list);
        }
    }
    
    class Node {
        String email;
        List<Node> neighbors;
        
        public Node(String email) {
            this.email = email;
            this.neighbors = new ArrayList<>();
        }
        
        public void addNeighbor(Node node) {
            neighbors.add(node);
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(email).append("###");
            neighbors.forEach(neighbor -> sb.append(neighbor.email).append("#"));
            return sb.toString();
        }
    }
}
