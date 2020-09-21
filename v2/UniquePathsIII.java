/* https://leetcode.com/problems/unique-paths-iii/ */
class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        // find starting square
        int startRow = -1, startCol = -1, numObstacles = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                    break;
                } else if (grid[i][j] == -1) {
                    numObstacles++;
                }
            }
        }
        
        // dfs
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, startRow, startCol, visited, 0, (grid.length * grid[0].length) - numObstacles - 1);
    }
    
    private int dfs(int[][] grid, int row, int col, boolean[][] visited, int numVisited, int total) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1 || visited[row][col]) {
            return 0;
        } else if (grid[row][col] == 2) {
            return numVisited == total ? 1 : 0;
        }
        
        visited[row][col] = true;
        int count = dfs(grid, row, col - 1, visited, numVisited + 1, total);
        count += dfs(grid, row - 1, col, visited, numVisited + 1, total);
        count += dfs(grid, row, col + 1, visited, numVisited + 1, total);
        count += dfs(grid, row + 1, col, visited, numVisited + 1, total);
        visited[row][col] = false;
        
        return count;
    }
}
