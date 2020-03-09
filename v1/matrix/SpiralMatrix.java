/**
 * Spiral matrix (143):
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example, given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }

        int total = matrix.length * matrix[0].length;
        System.out.println("total: " + total);
        int count = 0;
        int rowStart = 1;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (count < total) {
            // left to right
            System.out.printf("colStart: %d, colEnd: %d%n", colStart, colEnd);
            for (int col = colStart; col <= colEnd; ++col) {
                result.add(matrix[rowStart - 1][col]);
                ++count;
            }
            if (count == total) {
                break;
            }
            int tmp = colStart;
            colStart = colEnd - 1;
            colEnd = tmp;

            // top to down
            System.out.printf("rowStart: %d, rowEnd: %d%n", rowStart, rowEnd);
            for (int row = rowStart; row <= rowEnd; ++row) {
                result.add(matrix[row][colStart + 1]);
                ++count;
            }
            if (count == total) {
                break;
            }
            tmp = rowStart;
            rowStart = rowEnd - 1;
            rowEnd = tmp;

            // right to left
            System.out.printf("colStart: %d, colEnd: %d%n", colStart, colEnd);
            for (int col = colStart; col >= colEnd; --col) {
                result.add(matrix[rowStart + 1][col]);
                ++count;
            }
            if (count == total) {
                break;
            }
            tmp = colStart;
            colStart = colEnd + 1;
            colEnd = tmp;

            // bottom to top
            System.out.printf("rowStart: %d, rowEnd: %d%n", rowStart, rowEnd);
            for (int row = rowStart; row >= rowEnd; --row) {
                result.add(matrix[row][colStart - 1]);
                ++count;
            }
            tmp = rowStart;
            rowStart = rowEnd + 1;
            rowEnd = tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <num rows> <num cols> <element1> [<element2>...]");
            System.exit(1);
        }

        int numRows = Integer.parseInt(args[0]);
        int numCols = Integer.parseInt(args[1]);
        int[][] m = new int[numRows][numCols];
        int row = -1;
        int col = 0;
        for (int i = 2; i < args.length; ++i) {
            if ((i - 2) % numCols == 0) {
                ++row;
            }

            m[row][(i - 2) % numCols] = Integer.parseInt(args[i]);
        }
        System.out.println("input:");
        printMatrix(m, numRows, numCols);

        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> result = sm.spiralOrder(m);
        System.out.println("output: " + result.toString());
    }

    private static void printMatrix(int[][] m, int numRows, int numCols) {
        System.out.println("[");
        for (int i = 0; i < numRows; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < numCols; ++j) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
