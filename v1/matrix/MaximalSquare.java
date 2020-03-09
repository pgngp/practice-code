/**
 * Maximal square (69):
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1101
 * 1101
 * 1111
 * Return 4.
 * http://www.programcreek.com/2014/06/leetcode-maximal-square-java/
 */

/**
 * time: O(m*n)
 * space: O(n)
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // initialize
        int m = matrix.length;
        int n = matrix[0].length;
        int[] areas = new int[n];
        int max = 0;
        for (int col = n - 1; col >= 0; --col) {
            if (matrix[m - 1][col] == '1') {
                areas[col] = 1;
                max = 1;
            }
        }

        // rest of the matrix
        for (int row = m - 2; row >= 0; --row) {
            int right = (matrix[row][n - 1] == '1') ? 1 : 0;
            for (int col = n - 2; col >= 0; --col) {
                if (matrix[row][col] == '0') {
                    areas[col + 1] = right;
                    right = 0;
                    continue;
                }

                int min = Math.min(right, Math.min(areas[col], areas[col + 1]));
                int tmp = (int) Math.sqrt(min) + 1;
                int curr = tmp * tmp;
                max = Math.max(max, curr);
                areas[col + 1] = right;
                right = curr;
            }
            areas[0] = right;
            max = Math.max(max, right);
        }

        return max;
    }

    /*
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                if (matrix[row][col] == '1') {
                    maxArea = Math.max(maxArea, getArea(matrix, row, col));
                }
            }
        }

        return maxArea;
    }

    private int getArea(char[][] matrix, int row, int col) {
        int width = 1;
        boolean keepGoing = true;
        while (keepGoing) {
            ++width;
            int colEnd = col + width - 1;
            int rowStart = row + width - 1;
            if (colEnd >= matrix[0].length || rowStart >= matrix.length) {
                break;
            }

            // left to right
            for (int j = col; j <= colEnd; ++j) {
                if (matrix[rowStart][j] == '0') {
                    keepGoing = false;
                    break;
                }
            }
            
            if (!keepGoing) {
                break;
            }

            // bottom to top
            for (int i = rowStart - 1; i >= row; --i) {
                if (matrix[i][colEnd] == '0') {
                    keepGoing = false;
                    break;
                }
            }
        }
        --width;

        return width * width;
    }
    */

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

        MaximalSquare ms = new MaximalSquare();
        int count = ms.maximalSquare(grid);
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
