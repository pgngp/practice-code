/* https://leetcode.com/problems/island-perimeter/ */
class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int perimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                
                // left
                if (col == 0 || grid[row][col - 1] == 0) {
                    perimeter++;
                }
                
                // top
                if (row == 0 || grid[row - 1][col] == 0) {
                    perimeter++;
                }
                
                // right
                if (col == grid[0].length - 1 || grid[row][col + 1] == 0) {
                    perimeter++;
                }
                
                // bottom
                if (row == grid.length - 1 || grid[row + 1][col] == 0) {
                    perimeter++;
                }
            }
        }
        
        return perimeter;
    }
}
