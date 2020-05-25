/* https://leetcode.com/problems/uncrossed-lines/ */
class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] m = new int[A.length + 1][B.length + 1];
        for (int r = 1; r < m.length; r++) {
            for (int c = 1; c < m[0].length; c++) {
                if (A[r - 1] == B[c - 1]) {
                    m[r][c] = Math.max(m[r - 1][c - 1] + 1, Math.max(m[r][c - 1], m[r - 1][c]));
                } else {
                    m[r][c] = Math.max(m[r][c - 1], m[r - 1][c]);
                }
            }
        }
        // print(m);
        
        return m[m.length - 1][m[0].length - 1];
    }
    
    private void print(int[][] m) {
        System.out.println("m:");
        System.out.println("[");
        for (int r = 0; r < m.length; r++) {
            System.out.print("  [  ");
            for (int c = 0; c < m[0].length; c++) {
                System.out.print(m[r][c] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
