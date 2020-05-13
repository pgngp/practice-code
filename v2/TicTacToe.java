class TicTacToe {
    private int[][] m;
    private int[][] rowCounts;
    private int[][] colCounts;
    private int[][] diagCounts;
    private boolean gameOver;
    private int winner;
    private int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        m = new int[n][n];
        rowCounts = new int[n][2];
        colCounts = new int[n][2];
        diagCounts = new int[2][2];
        gameOver = false;
        winner = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // if game over
        if (gameOver) {
            return winner;
        }
        
        // mark player on the position
        m[row][col] = player;
        
        // update row and col counts
        if (player == 1) {
            rowCounts[row][0]++;
            colCounts[col][0]++;
        } else {
            rowCounts[row][1]++;
            colCounts[col][1]++;
        }
        // print("rowCounts", rowCounts);
        // print("colCounts", colCounts);
        
        // update diag counts
        if (row == col) {
            if (player == 1) {
                diagCounts[0][0]++;
            } else {
                diagCounts[0][1]++;
            }
        }
        if (row == n - 1 - col) {
            if (player == 1) {
                diagCounts[1][0]++;
            } else {
                diagCounts[1][1]++;
            }
        }
        // print("diagCounts", diagCounts);
        
        // check if there are any winners
        if (rowCounts[row][0] == n) {
            gameOver = true;
            winner = 1;
        } else if (rowCounts[row][1] == n) {
            gameOver = true;
            winner = 2;
        } else if (colCounts[col][0] == n) {
            gameOver = true;
            winner = 1;
        } else if (colCounts[col][1] == n) {
            gameOver = true;
            winner = 2;
        } else if (diagCounts[0][0] == n) {
            gameOver = true;
            winner = 1;
        } else if (diagCounts[0][1] == n) {
            gameOver = true;
            winner = 2;
        } else if (diagCounts[1][0] == n) {
            gameOver = true;
            winner = 1;
        } else if (diagCounts[1][1] == n) {
            gameOver = true;
            winner = 2;
        }
        
        return winner;
    }
    
    private void print(String label, int[][] m) {
        System.out.println(label + ":");
        System.out.println("[");
        for (int r = 0; r < m.length; ++r) {
            System.out.print("  [");
            for (int c = 0; c < m[0].length; ++c) {
                System.out.print(" " + m[r][c]);
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
