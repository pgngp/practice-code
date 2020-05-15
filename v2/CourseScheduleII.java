class CourseScheduleII {
    private Map<Integer, Node> nodes;
    private Map<Node, Integer> colors;
    private Deque<Node> stack;
    private static final int WHITE = 1;
    private static final int GRAY = 2;
    private static final int BLACK = 3;
    private boolean hasCycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // sanity check
        if (numCourses == 0 || prerequisites == null) {
            return new int[0];
        }
        
        // create all nodes
        nodes = new HashMap<>();
        colors = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Node node = new Node(i);
            nodes.put(i, node);
            colors.put(node, WHITE);
        }
        // System.out.println("colors: " + colors);
        
        // create dependencies
        for (int i = 0; i < prerequisites.length; i++) {
            Node parent = nodes.get(prerequisites[i][0]);
            Node child = nodes.get(prerequisites[i][1]);
            parent.children.add(child);
        }
        // System.out.println("nodes: " + nodes);
        
        // topological sort using dfs
        stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            Node node = nodes.get(i);
            if (colors.get(node) == WHITE) {
                dfs(node);   
            }
        }
        
        // if there's a cycle
        if (hasCycle) {
            return new int[0];
        }
        
        // output to result array
        int[] result = new int[numCourses];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pollFirst().val;
        }
        
        return result;
    }
    
    private void dfs(Node node) {
        colors.put(node, GRAY);
        for (Node child : node.children) {
            int color = colors.get(child);
            if (color == WHITE) {
                dfs(child);   
            } else if (color == GRAY) {
                hasCycle = true;
                return;
            }
        }
        colors.put(node, BLACK);
        stack.offerFirst(node);
    }
    
    public class Node {
        private int val;
        private List<Node> children;
        
        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(val).append(",children:");
            children.forEach(child -> sb.append(child.val).append(","));
            sb.append(")");
            
            return sb.toString();
        }
    }
}
