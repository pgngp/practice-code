/**
 * Minimum path sum (101):
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * http://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/
 */

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        // right-most column
        for (int row = grid.length - 2; row >= 0; --row) {
            grid[row][grid[0].length - 1] += grid[row + 1][grid[0].length - 1];
        }

        // bottom-most row
        for (int col = grid[0].length - 2; col >= 0; --col) {
            grid[grid.length - 1][col] += grid[grid.length - 1][col + 1];
        }

        // remaining cells
        for (int row = grid.length - 2; row >= 0; --row) {
            for (int col = grid[0].length - 2; col >= 0; --col) {
                grid[row][col] += Math.min(grid[row + 1][col], grid[row][col + 1]);
            }
        }

        return grid[0][0];
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <m> <n> <element1> [<element>...]");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[][] grid = new int[m][n];
        for (int i = 2; i < args.length; ++i) {
            int row = (i - 2) / n;
            int col = (i - 2) % n;
            grid[row][col] = Integer.parseInt(args[i]);
        }
        System.out.println("Input:");
        printMatrix(grid);

        MinPathSum mps = new MinPathSum();
        int sum = mps.minPathSum(grid);
        System.out.println("Min sum: " + sum);
    }

    private static void printMatrix(int[][] m) {
        System.out.println("[");
        for (int i = 0; i < m.length; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < m[0].length; ++j) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
