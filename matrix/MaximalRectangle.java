/**
 * Maximal rectangle (51):
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * http://www.programcreek.com/2014/05/leetcode-maximal-rectangle-java/
 */

/**
 * time: O((m ^ 2) * (n ^ 2))
 * space: O(1)
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                if (matrix[row][col] == '0') {
                    continue;
                }
                max = Math.max(max, getMaxArea(matrix, row, col));
            }
        }

        return max;
    }

    private int getMaxArea(char[][] matrix, int row, int col) {
        int maxArea = 0;
        int colEnd = matrix[0].length - 1;
        for (int i = row; i < matrix.length; ++i) {
            if (matrix[i][col] == '0') {
                maxArea = Math.max(maxArea, i - row);
                break;
            }

            int area = 0;
            for (int j = col; j <= colEnd; ++j) {
                if (matrix[i][j] == '0') {
                    colEnd = j - 1;
                    break;
                }
                ++area;
            }
            area *= i - row + 1;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
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

        MaximalRectangle mr = new MaximalRectangle();
        int count = mr.maximalRectangle(grid);
        System.out.println("Max area: " + count);
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
