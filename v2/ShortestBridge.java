/* https://leetcode.com/problems/shortest-bridge/ */
class ShortestBridge {
    public int shortestBridge(int[][] A) {
        // find 1st island
        Deque<int[]> q = new ArrayDeque<>();
        boolean foundFirstIsland = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, q);
                    foundFirstIsland = true;
                    break;
                }        
            }
            if (foundFirstIsland) {
                break;
            }
        }
        
        // find 2nd island
        return bfs(A, q);
    }
    
    private void dfs(int[][] A, int i, int j, Deque<int[]> q) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1) {
            return;
        }
        
        q.offerLast(new int[] {i, j});
        A[i][j] = 2;
        dfs(A, i, j - 1, q);
        dfs(A, i - 1, j, q);
        dfs(A, i, j + 1, q);
        dfs(A, i + 1, j, q);
    }
    
    private int bfs(int[][] A, Deque<int[]> q) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.pollFirst();
                int row = cell[0], col = cell[1];
                
                if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                
                if (A[row][col] == 1) {
                    return steps - 1;
                }
                
                q.offer(new int[] {row, col - 1});
                q.offer(new int[] {row - 1, col});
                q.offer(new int[] {row, col + 1});
                q.offer(new int[] {row + 1, col});
            }
            steps++;
        }
        
        return steps;
    }
}
