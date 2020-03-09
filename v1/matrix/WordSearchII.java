/**
 * Word search II (61):
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * For example, given words = ["oath","pea","eat","rain"] and board =
 * [
 *  ['o','a','a','n'],
 *  ['e','t','a','e'],
 *  ['i','h','k','r'],
 *  ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * http://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
 */

/**
 * time: O(k*(mn)^2) where k is number of words, m is num rows in matrix, n is num cols
 * space: O(1)
 */

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        } 

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            char c = word.charAt(0);
            for (int row = 0; row < m; ++row) {
                for (int col = 0; col < n; ++col) {
                    if (c == board[row][col]) {
                        if (hasWord(board, word, 0, row, col)) {
                            result.add(word);
                            row = m;
                            break;
                        }
                    }
                }
            }
        }

        return result;
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
        if (args.length < 5) {
            System.out.println("Usage: java <prog> <numWords> <word> [<word>...] <m> <n> <element> [<element>...]");
            System.exit(1);
        }

        int numWords = Integer.parseInt(args[0]);
        String[] words = new String[numWords];
        int idx = 0;
        for (int i = 1; i < 1 + numWords; ++i) {
            words[idx++] = args[i];
        }
        System.out.print("Words: [ ");
        for (int i = 0; i < numWords; ++i) {
            System.out.print(words[i] + " ");
        }
        System.out.println("]");

        int m = Integer.parseInt(args[numWords + 1]);
        int n = Integer.parseInt(args[numWords + 2]);

        char[][] board = new char[m][n];
        idx = 0;
        for (int i = numWords + 3; i < args.length; ++i) {
            int row = idx / n;
            int col = idx % n;
            board[row][col] = args[i].charAt(0);
            ++idx;
        }
        System.out.println("Board:");
        printMatrix(board);

        WordSearchII ws = new WordSearchII();
        List<String> list = ws.findWords(board, words);
        System.out.println("Output: " + list.toString());
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
