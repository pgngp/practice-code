/* https://leetcode.com/problems/longest-increasing-path-in-a-matrix/ */
class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                max = Math.max(max, getMax(matrix, cache, row, col));
            }
        }
        
        return max;
    }
    
    private int getMax(int[][] matrix, int[][] cache, int row, int col) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        
        int max = 0;
        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            max = Math.max(max, getMax(matrix, cache, row, col - 1));
        }
        
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            max = Math.max(max, getMax(matrix, cache, row - 1, col));
        }
        
        if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) {
            max = Math.max(max, getMax(matrix, cache, row, col + 1));
        }
        
        if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) {
            max = Math.max(max, getMax(matrix, cache, row + 1, col));
        }
        
        cache[row][col] = max + 1;
        
        return max + 1;
    }
}
