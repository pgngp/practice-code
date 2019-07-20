/**
 * Search a 2D matrix (129):
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:
 * 1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last integer of the previous row.
 * For example, consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * http://www.programcreek.com/2013/01/leetcode-search-a-2d-matrix-java/
 */

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = (rows * cols) - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midX = mid / cols;
            int midY = mid % cols;

            if (target == matrix[midX][midY]) {
                return true;
            } else if (target < matrix[midX][midY]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[lastRow][lastCol]) {
            return false;
        }

        for (int row = 0; row < matrix.length; ++row) {
            if (target > matrix[row][lastCol]) {
                continue;
            }

            return bsearch(matrix[row], 0, lastCol, target);
        }

        return false;
    }

    private boolean bsearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <target> <num rows> <num cols> <element1> [<element2>...]");
            System.exit(1);
        }

        int target = Integer.parseInt(args[0]);
        int numRows = Integer.parseInt(args[1]);
        int numCols = Integer.parseInt(args[2]);
        int[][] m = new int[numRows][numCols];
        int row = -1;
        int col = 0;
        for (int i = 3; i < args.length; ++i) {
            if ((i - 3) % numCols == 0) {
                ++row;
            }

            m[row][(i - 3) % numCols] = Integer.parseInt(args[i]);
        }
        System.out.println("input:");
        printMatrix(m, numRows, numCols);

        Search2DMatrix sm = new Search2DMatrix();
        boolean result = sm.searchMatrix(m, target);
        System.out.println("output: " + result);
    }

    private static void printMatrix(int[][] m, int numRows, int numCols) {
        System.out.println("[");
        for (int i = 0; i < numRows; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < numCols; ++j) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
