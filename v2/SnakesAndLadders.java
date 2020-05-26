/* https://leetcode.com/problems/snakes-and-ladders/ */
class SnakesAndLadders {    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        int steps = 0;
        boolean[] visited = new boolean[(n * n) + 1];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        visited[1] = true;
        q.offerLast(-1);
        while (!q.isEmpty()) {
            int current = q.pollFirst();
            // System.out.println(current);
            if (current == -1) {
                steps++;
                if (!q.isEmpty()) {
                    q.offerLast(-1);   
                }
                continue;
            } else if (current == target) {
                return steps;
            }
            
            for (int i = current + 1; i <= Math.min(target, current + 6); i++) {
                int val = getCellValue(board, i - 1);
                if (val == -1 && !visited[i]) {
                    q.offerLast(i);
                    visited[i] = true;
                } else if (val != -1 && !visited[val]) {
                    q.offerLast(val);
                    visited[val] = true;
                }
            }
        }
        
        return -1;
    }
    
    private int getCellValue(int[][] board, int idx) {
        int n = board.length;
        int row = n - ((idx / n) + 1);
        int col = (idx % n);
        if ((n % 2 == 0 && row % 2 == 0) || (n % 2 == 1 && row % 2 == 1)) {
            col = n - col - 1;
        }

        return board[row][col];
    }
}
