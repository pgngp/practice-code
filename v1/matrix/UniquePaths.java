/**
 * Unique paths (117):
 * A robot is located at the top-left corner of a m x n grid. It can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * http://www.programcreek.com/2014/05/leetcode-unique-paths-java/
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 && n == 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else if (m == 1 || n == 1) {
            return 1;
        }

        int[] arr = new int[n];
        arr[n - 1] = 1;

        for (int row = m - 2; row >= 0; --row) {
            for (int col = n - 2; col >= 0; --col) {
                if (row == m - 2) {
                    arr[col] = 1 + arr[col + 1];
                } else if (col == n - 2) {
                    arr[col] = arr[col] + 1;
                } else {
                    arr[col] = arr[col] + arr[col + 1];
                }
            }
        }

        return arr[0];
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java <prog> <m> <n>");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        UniquePaths up = new UniquePaths();
        int numPaths = up.uniquePaths(m, n);
        System.out.println("Output: " + numPaths);
    }
}
