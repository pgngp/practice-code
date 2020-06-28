/* https://leetcode.com/problems/sparse-matrix-multiplication/ */
class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                
                for (int j = 0; j < B[0].length; j++) {
                    if (B[k][j] == 0) {
                        continue;
                    }
                    
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return result;
    }
}
