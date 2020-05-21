/* https://leetcode.com/problems/count-square-submatrices-with-all-ones/ */
class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        int count = 0;
        
        // top-most row
        for (int c = 0; c < matrix[0].length; c++) {
            count += matrix[0][c];
        }
        
        // left-most col
        for (int r = 1; r < matrix.length; r++) {
            count += matrix[r][0];
        }
        
        // remaining cells
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    continue;
                }
                matrix[r][c] = Math.min(matrix[r][c - 1], Math.min(matrix[r - 1][c - 1], matrix[r - 1][c])) + 1;
                count += matrix[r][c];
            }
        }
        
        return count;
    }
}
