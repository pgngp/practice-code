/**
 * Surrounded regions (184):
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * http://www.programcreek.com/2014/04/leetcode-surrounded-regions-java/
 */

/**
 * time: O(m * n)
 * space: O(1)
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // top row
        for (int col = 0; col < n; ++col) {
            if (board[0][col] == 'O') {
                helper(board, 0, col);
            }
        }

        // bottom row
        for (int col = 0; col < n; ++col) {
            if (board[m - 1][col] == 'O') {
                helper(board, m - 1, col);
            }
        }

        // left-most column
        for (int row = 1; row < m - 1; ++row) {
            if (board[row][0] == 'O') {
                helper(board, row, 0);
            }
        }

        // right-most column
        for (int row = 1; row < m - 1; ++row) {
            if (board[row][n - 1] == 'O') {
                helper(board, row, n - 1);
            }
        }

        // convert all Y's to O's
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'Y') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void helper(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'Y';
        helper(board, row - 1, col);
        helper(board, row, col - 1);
        helper(board, row + 1, col);
        helper(board, row, col + 1);
    }

    /*
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int row = 1; row < m - 1; ++row) {
            for (int col = 1; col < n - 1; ++col) {
                if (board[row][col] == 'O' || board[row][col] == 'Z') {
                    if (board[row][col] == 'Z') {
                        board[row][col] = 'O';
                    }

                    if (isSurrounded(board, row, col)) {
                        board[row][col] = 'X';
                    }
                }
            }
        }

        
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (board[row][col] == 'Y') {
                    board[row][col] = 'O';
                }
            }
        }
        
    }
 
    private boolean isSurrounded(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == 'Y') {
            return false;
        } else if (board[row][col] == 'X' || board[row][col] == 'Z') {
            return true;
        }

        board[row][col] = 'Z';
        if (
                isSurrounded(board, row - 1, col)
                && isSurrounded(board, row, col - 1)
                && isSurrounded(board, row + 1, col)
                && isSurrounded(board, row, col + 1)
        ) {
            return true;
        }
        board[row][col] = 'Y';

        return false;
    }*/

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <m> <n> <element1> [<element>...]");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        char[][] grid = new char[m][n];
        for (int i = 2; i < args.length; ++i) {
            int row = (i - 2) / n;
            int col = (i - 2) % n;
            grid[row][col] = args[i].charAt(0);
        }
        System.out.println("Input:");
        printMatrix(grid);

        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(grid);
        System.out.println("Output:");
        printMatrix(grid);
    }

    private static void printMatrix(char[][] m) {
        System.out.println("[");
        for (int i = 0; i < m.length; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < m[0].length; ++j) {
                System.out.printf("%3c", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
