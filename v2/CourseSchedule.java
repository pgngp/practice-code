/* https://leetcode.com/problems/course-schedule/submissions/ */
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create nodes and put them in map
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Node node = new Node(i);
            nodes.put(i, node);
        }
        
        // add neighbors
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            Node node1 = nodes.get(a);
            Node node2 = nodes.get(b);
            node1.addNeighbor(node2);
        }
        
        // traverse the graph
        for (int course : nodes.keySet()) {
            Node node = nodes.get(course);            
            if (node.color == 0 && !dfs(node)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Node node) {
        if (node.color == 0) {
            node.color = 1;
        } else if (node.color == 1) {
            return false;
        } else if (node.color == 2) {
            return true;
        }
        
        for (Node neighbor : node.neighbors) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        node.color = 2;
        
        return true;
    }
    
    public class Node {
        private int val;
        private List<Node> neighbors;
        private int color;
        
        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
            this.color = 0;
        }
        
        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }
}
