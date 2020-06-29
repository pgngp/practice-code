/* https://leetcode.com/problems/reconstruct-itinerary/ */
class ReconstructItinerary {
    //  f("jfk")
    //  function f(start)
    //      while start has children
    //          pick the top child
    //          f(child)
    //      stack.add(start)
    //      
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return new ArrayList<>();
        }
        
        // create nodes and add them to map
        Map<String, Node> map = new HashMap<>();
        for (List<String> list : tickets) {
            String from = list.get(0);
            String to = list.get(1);
            
            if (!map.containsKey(from)) {
                map.put(from, new Node(from));
            }
            
            if (!map.containsKey(to)) {
                map.put(to, new Node(to));
            }
            
            map.get(from).addChild(map.get(to));
        }
        
        // create a stack
        Deque<Node> stack = new ArrayDeque<>();
        
        // DFS
        helper(map.get("JFK"), stack);
        
        // move data from stack to output
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pollFirst().name);
        }
        
        return result;
    }
    
    private void helper(Node node, Deque<Node> stack) {
        while (node.hasChild()) {
            Node child = node.getNextChild();
            helper(child, stack);
        }
        stack.offerFirst(node);
    }
    
    class Node {
        private String name;
        private PriorityQueue<Node> children;
        
        public Node(String name) {
            this.name = name;
            this.children = new PriorityQueue<>((a, b) -> a.name.compareTo(b.name));
        }
        
        public boolean hasChild() {
            return !children.isEmpty();
        }
        
        public Node getNextChild() {
            return children.poll();
        }
        
        public void addChild(Node child) {
            children.offer(child);
        }
    }
}
