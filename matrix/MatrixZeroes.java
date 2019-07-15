/**
 * Set matrix zeroes (89):
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * http://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/
 */

import java.util.Arrays;

public class MatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowsWithZero = new boolean[rows];
        boolean[] colsWithZero = new boolean[cols];

        // scan
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    rowsWithZero[i] = true;
                    colsWithZero[j] = true;
                }
            }
        }

        // set rows to zero
        for (int i = 0; i < rows; ++i) {
            if (rowsWithZero[i]) {
                for (int j = 0; j < cols; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set cols to zero
        for (int j = 0; j < cols; ++j) {
            if (colsWithZero[j]) {
                for (int i = 0; i < rows; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <num rows> <num cols> <element1> <element2> [...]");
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

        MatrixZeroes mz = new MatrixZeroes();
        mz.setZeroes(m);
        System.out.println("output:");
        printMatrix(m, numRows, numCols);
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
