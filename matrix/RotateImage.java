/**
 * Rotate image (128):
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
 */

/**
 * time: O(n * n)
 * space: O(1)
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rowStart = 0;
        int rowEnd = (matrix.length + 1) / 2;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int maxCols = matrix.length;
        for (int row = rowStart; row < rowEnd; ++row) {
            for (int col = colStart; col < colEnd; ++col) {
                int nextRow = col;
                int nextCol = maxCols - 1 - row; 
                int tmp1 = matrix[row][col];
                int tmp2 = matrix[nextRow][nextCol];
                while (nextRow != row || nextCol != col) {
                    matrix[nextRow][nextCol] = tmp1;
                    int tmpRow = nextRow;
                    nextRow = nextCol;
                    nextCol = maxCols - 1 - tmpRow;
                    tmp1 = tmp2;
                    tmp2 = matrix[nextRow][nextCol];
                }
                matrix[nextRow][nextCol] = tmp1;
            }
            ++colStart;
            --colEnd;
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
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

        RotateImage ri = new RotateImage();
        ri.rotate(m);
        System.out.println("output: ");
        printMatrix(m, numRows, numCols);
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
