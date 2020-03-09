/**
 * Word search (149):
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example, given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * http://www.programcreek.com/2014/06/leetcode-word-search-java/
 */

/**
 * time: O((mn)^2)
 * space: O(mn)
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (word.charAt(0) == board[row][col]) {
                    if (hasWord(board, word, 0, row, col)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean hasWord(char[][] board, String word, int wordIdx, int row, int col) {
        if (row < 0 
               || row >= board.length 
               || col < 0 
               || col >= board[0].length 
               || word.charAt(wordIdx) != board[row][col]) {
            return false;
        }

        board[row][col] = '#';
        boolean result = false;
        ++wordIdx;
        if (wordIdx >= word.length()
               || hasWord(board, word, wordIdx, row - 1, col)
               || hasWord(board, word, wordIdx, row, col - 1)
               || hasWord(board, word, wordIdx, row + 1, col)
               || hasWord(board, word, wordIdx, row, col + 1)) {
            result = true;
        }
        board[row][col] = word.charAt(wordIdx - 1);

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <word> <m> <n> <element> [<element>...]");
            System.exit(1);
        }

        String word = args[0];
        System.out.printf("Word: %s%n", word);
        int m = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);
        char[][] board = new char[m][n];
        int index = 3;
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                board[row][col] = args[index].charAt(0);
                ++index;
            }
        }
        System.out.println("Input: ");
        printMatrix(board);

        WordSearch ws = new WordSearch();
        boolean result = ws.exist(board, word);
        System.out.println("After: ");
        printMatrix(board);
        System.out.println("Result: " + result);
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

    private static void printMatrix(int[][] m) {
        System.out.println("[");
        for (int i = 0; i < m.length; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < m[0].length; ++j) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
