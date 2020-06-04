/* https://leetcode.com/problems/number-of-distinct-islands/ */
class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        Set<String> pathsSeen = new HashSet<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, r, c, sb, "o");
                    String path = sb.toString();
                    if (!pathsSeen.contains(path)) {
                        pathsSeen.add(path);
                        count++;
                    }
                }
            }
        }
        // System.out.println("pathseen: " + pathsSeen);
        // print(grid);
        
        return count;
    }
    
    private void dfs(int[][] grid, int r, int c, StringBuilder sb, String direction) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }
    
        sb.append(direction);
        grid[r][c] = 2;
        dfs(grid, r, c - 1, sb, "l");
        dfs(grid, r - 1, c, sb, "u");
        dfs(grid, r, c + 1, sb, "r");
        dfs(grid, r + 1, c, sb, "d");
        sb.append("b");
    }
    
    private void print(int[][] grid) {
        System.out.println("[");
        for (int r = 0; r < grid.length; r++) {
            System.out.print("  [  ");
            for (int c = 0; c < grid[0].length; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
