/* https://leetcode.com/problems/the-maze/ */
class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        return dfs(maze, start, destination, visited, dirs);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited, int[][] dirs) {
        if (start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }
        
        int x = start[0], y = start[1];
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int[] prevCell = null, cell = new int[] {x + dir[0], y + dir[1]};
            while (!isWall(maze, cell)) {
                prevCell = cell;
                cell = new int[] {cell[0] + dir[0], cell[1] + dir[1]};
            }
            
            if (prevCell != null && !visited[prevCell[0]][prevCell[1]] && dfs(maze, prevCell, dest, visited, dirs)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isWall(int[][] maze, int[] cell) {
        int x = cell[0], y = cell[1];
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 1) {
            return true;
        }
        
        return false;
    }
}
