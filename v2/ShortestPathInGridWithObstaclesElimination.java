/* https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/ */
class ShortestPathInGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);  
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] {0, 0, 0});
        int steps = 0;
        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                // pop out the queue
                int[] cell = q.pollFirst();
                
                // if we reached the end
                int row = cell[0], col = cell[1];
                if (row == m - 1 && col == n - 1) {
                    return steps;
                }
                
                // add neighbors to queue
                for (int j = 0; j < dirs.length; j++) {
                    int r = row + dirs[j][0], c = col + dirs[j][1];
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        continue;
                    }
                    
                    int cost = cell[2] + grid[r][c];
                    if (cost >= seen[r][c] || cost > k) {
                        continue;
                    }
                    seen[r][c] = cost;
                    q.offerLast(new int[] {row + dirs[j][0], col + dirs[j][1], cost});
                }
            }
            steps++;
        }
        
        return -1;
    }
}
