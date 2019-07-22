/**
 * Valid sudoku (147):
 * Determine if a Sudoku is valid. The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * http://www.programcreek.com/2014/05/leetcode-valid-sudoku-java/
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 9 || board[0].length < 9) {
            return false;
        }

        // check each row
        for (int row = 0; row < 9; ++row) {
            boolean[] set = new boolean[9];
            for (int col = 0; col < 9; ++col) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                } else if (c < '1' || c > '9' || set[c - '1']) {
                    return false;
                }
                set[c - '1'] = true;
            }
        }

        // check each col
        for (int col = 0; col < 9; ++col) {
            boolean[] set = new boolean[9];
            for (int row = 0; row < 9; ++row) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                } else if (set[c - '1']) {
                    return false;
                }
                set[c - '1'] = true;
            }
        }

        // check each sub-matrix
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] set = new boolean[9];
                for (int i = row; i < row + 3; ++i) {
                    for (int j = col; j < col + 3; ++j) {
                        char c = board[i][j];
                        if (c == '.') {
                            continue;
                        } else if (set[c - '1']) {
                            return false;
                        }
                        set[c - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length != 81) {
            System.out.println("Usage: java <prog> <element1> <element2> ... <element81>");
            System.exit(1);
        }

        char[][] arr = new char[9][9];
        for (int i = 0; i < args.length; ++i) {
            int row = i / 9;
            int col = i % 9;
            arr[row][col] = args[i].charAt(0);
        }

        ValidSudoku vs = new ValidSudoku();
        boolean result = vs.isValidSudoku(arr);
        System.out.println(result);
    }
}
