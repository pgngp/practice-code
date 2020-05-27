/* https://leetcode.com/problems/possible-bipartition/ */
class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // build graph adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        // traverse the graph and color each node appropriately
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(adjList, i, colors, 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> adjList, int idx, int[] colors, int color) {
        colors[idx] = color;
        List<Integer> neighbors = adjList.get(idx);
        for (int i = 0; i < neighbors.size(); i++) {
            int node = neighbors.get(i);
            if (color == colors[node]) {
                return false;
            } else if (colors[node] == 0) {
                colors[node] = color == 1 ? 2 : 1;
                if (!dfs(adjList, node, colors, colors[node])) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
