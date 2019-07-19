/**
 * Spiral matrix II (108):
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order. For example, given n = 4,
 * [
 * [1,   2,  3, 4],
 * [12, 13, 14, 5],
 * [11, 16, 15, 6],
 * [10,  9,  8, 7]
 * ]
 * http://www.programcreek.com/2014/05/leetcode-spiral-matrix-ii-java/
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        if (n < 0) {
            throw new IllegalArgumentException("invalid input");
        } else if (n == 0) {
            return m;
        } else if (n == 1) {
            m[0][0] = 1;
            return m;
        }

        int num = 1;
        int total = n * n;
        int rowStart = 1;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        while (num <= total) {
            // left to right
            for (int col = colStart; col <= colEnd; ++col) {
                m[rowStart - 1][col] = num;
                ++num;
            }
            if (num > total) {
                break;
            }
            int tmp = colStart;
            colStart = colEnd - 1;
            colEnd = tmp;

            // top to bottom
            for (int row = rowStart; row <= rowEnd; ++row) {
                m[row][colStart + 1] = num;
                ++num;
            }
            if (num > total) {
                break;
            }
            tmp = rowStart;
            rowStart = rowEnd - 1;
            rowEnd = tmp;

            // right to left
            for (int col = colStart; col >= colEnd; --col) {
                m[rowStart + 1][col] = num;
                ++num;
            }
            if (num > total) {
                break;
            }
            tmp = colStart;
            colStart = colEnd + 1;
            colEnd = tmp;

            // bottom to top
            for (int row = rowStart; row >= rowEnd; --row) {
                m[row][colStart - 1] = num;
                ++num;
            }
            tmp = rowStart;
            rowStart = rowEnd + 1;
            rowEnd = tmp;
        }

        return m;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java <prog> <n>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        SpiralMatrixII sm = new SpiralMatrixII();
        int[][] m = sm.generateMatrix(n);
        printMatrix(m, m.length, m.length);
    }

    private static void printMatrix(int[][] m, int numRows, int numCols) {
        System.out.println("[");
        for (int i = 0; i < numRows; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < numCols; ++j) {
                //System.out.print(m[i][j] + " ");
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
