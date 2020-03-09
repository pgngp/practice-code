/**
 * Number of islands (161):
 * Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * http://www.programcreek.com/2014/04/leetcode-number-of-islands-java/
 */

/**
 * time: O((m^2) * (n^2))
 * space: O(m * n)
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (grid[row][col] == '1') {
                    ++count;
                    clearIsland(grid, row, col);
                }
            }
        }

        return count;
    }

    private void clearIsland(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        clearIsland(grid, row, col - 1);
        clearIsland(grid, row - 1, col);
        clearIsland(grid, row, col + 1);
        clearIsland(grid, row + 1, col);
    }
    
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <m> <n> <element1> [<element>...]");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        char[][] grid = new char[m][n];
        for (int i = 2; i < args.length; ++i) {
            int row = (i - 2) / n;
            int col = (i - 2) % n;
            grid[row][col] = args[i].charAt(0);
        }
        System.out.println("Input:");
        printMatrix(grid);

        NumberOfIslands noi = new NumberOfIslands();
        int count = noi.numIslands(grid);
        System.out.println("After:");
        printMatrix(grid);
        System.out.println("Num islands: " + count);
    }

    private static void printMatrix(char[][] m) {
        System.out.println("[");
        for (int i = 0; i < m.length; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < m[0].length; ++j) {
                System.out.printf("%3c", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
