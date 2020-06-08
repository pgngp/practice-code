/* https://leetcode.com/problems/path-with-maximum-minimum-value/ */
class PathWithMaxMinVal {
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        pq.offer(new Cell(A[0][0], 0, 0));
        A[0][0] = -1;
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int val = cell.val;
            int row = cell.row;
            int col = cell.col;
            min = Math.min(min, val);
            A[row][col] = -1;
            
            if (row == A.length - 1 && col == A[0].length - 1) {
                break;
            }
            
            if (col > 0 && A[row][col - 1] != -1) {
                pq.offer(new Cell(A[row][col - 1], row, col - 1));
            }
            
            if (row > 0 && A[row - 1][col] != -1) {
                pq.offer(new Cell(A[row - 1][col], row - 1, col));
            }
            
            if (col < A[0].length - 1 && A[row][col + 1] != -1) {
                pq.offer(new Cell(A[row][col + 1], row, col + 1));
            }
            
            if (row < A.length - 1 && A[row + 1][col] != -1) {
                pq.offer(new Cell(A[row + 1][col], row + 1, col));
            }
        }
        
        return min;
    }
    
    public class Cell {
        private int val;
        private int row;
        private int col;
        
        public Cell(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
