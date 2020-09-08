/* https://leetcode.com/problems/image-overlap/ */
class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int numMaxOverlaps = 0;
        for (int rowShift = 0; rowShift < A.length; rowShift++) {
            for (int colShift = 0; colShift < A.length; colShift++) {
                numMaxOverlaps = Math.max(numMaxOverlaps, shiftAndCount(A, B, rowShift, colShift));
                numMaxOverlaps = Math.max(numMaxOverlaps, shiftAndCount(B, A, rowShift, colShift));
            }
        }
        
        return numMaxOverlaps;
    }
    
    private int shiftAndCount(int[][] A, int[][] B, int rowShift, int colShift) {
        int count = 0, rowB = 0;
        for (int rowA = rowShift; rowA < A.length; rowA++) {
            int colB = 0;
            for (int colA = colShift; colA < A.length; colA++) {
                if (A[rowA][colA] == 1 && B[rowB][colB] == 1) {
                    count++;
                }
                colB++;
            }
            rowB++;
        }
        
        return count;
    }
}
