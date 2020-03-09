/**
 * Unique paths II (92):
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid. For example, there is one obstacle in the middle of a 3x3 grid as illustrated below,
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * the total number of unique paths is 2.
 * http://www.programcreek.com/2014/05/leetcode-unique-paths-ii-java/
 */

/**
 * time: O(m x n)
 * space: O(n)
 */

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        } else if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        } else if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 1;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] arr = new int[n];
        arr[n - 1] = 1;

        // bottom-most row
        for (int col = n - 2; col >= 0; --col) {
            if (obstacleGrid[m - 1][col] == 1) {
                arr[col] = 0;
            } else {
                arr[col] = arr[col + 1];
            }
        }

        // remaining cells
        for (int row = m - 2; row >= 0; --row) {
            for (int col = n - 1; col >= 0; --col) {
                if (obstacleGrid[row][col] == 1) {
                    arr[col] = 0;
                } else if (col < n - 1) {
                    arr[col] = arr[col] + arr[col + 1];
                }
            }
        }

        return arr[0];
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

        UniquePathsII up = new UniquePathsII();
        int count = up.uniquePathsWithObstacles(grid);
        System.out.println("Num paths: " + count);
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
