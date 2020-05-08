class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (board[row][col] == word.charAt(0)) {
                    char orig = board[row][col];
                    board[row][col] = '#';
                    if (helper(board, word, 1, row, col)) {
                        return true;
                    }
                    board[row][col] = orig;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int idx, int row, int col) {        
        if (idx >= word.length()) {
            return true;
        }
        
        if (col > 0 && board[row][col - 1] == word.charAt(idx)) {
            char orig = board[row][col - 1];
            board[row][col - 1] = '#';
            if (helper(board, word, idx + 1, row, col - 1)) {
                return true;
            }
            board[row][col - 1] = orig;
        }
        
        if (row > 0 && board[row - 1][col] == word.charAt(idx)) {
            char orig = board[row - 1][col];
            board[row - 1][col] = '#';
            if (helper(board, word, idx + 1, row - 1, col)) {
                return true;
            }
            board[row - 1][col] = orig;
        }
        
        if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(idx)) {
            char orig = board[row][col + 1];
            board[row][col + 1] = '#';
            if (helper(board, word, idx + 1, row, col + 1)) {
                return true;
            }
            board[row][col + 1] = orig;
        }
        
        if (row < board.length - 1 && board[row + 1][col] == word.charAt(idx)) {
            char orig = board[row + 1][col];
            board[row + 1][col] = '#';
            if (helper(board, word, idx + 1, row + 1, col)) {
                return true;
            }
            board[row + 1][col] = orig;
        }
        
        return false;
    }
}
