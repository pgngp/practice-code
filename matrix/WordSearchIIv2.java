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

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class WordSearchIIv2 {
    /**
     * Returns words that exist in the matrix
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        } 

        TrieNode root = buildTrie(words);
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                hasWord(board, row, col, root, result);
            }
        }

        return result;
    }

    /**
     * Adds word to result list if it exists in matrix
     */
    private void hasWord(char[][] board, int row, int col, TrieNode n, List<String> result) {
        char c = board[row][col];
        if (c == '#') {
            return;
        } 
        n = n.map[c - 'a'];
        if (n == null) {
            return;
        } else if (n.word != null) {
            result.add(n.word);
            n.word = null;
        }

        board[row][col] = '#';
        if (row > 0) {
            hasWord(board, row - 1, col, n, result);
        }
        if (col > 0) {
            hasWord(board, row, col - 1, n, result);
        }
        if (row + 1 < board.length) {
            hasWord(board, row + 1, col, n, result);
        }
        if (col + 1 < board[0].length) {
            hasWord(board, row, col + 1, n, result);
        }
        board[row][col] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode n = root;
            for (char c : w.toCharArray()) {
                if (n.map[c - 'a'] == null) {
                    n.map[c - 'a'] = new TrieNode();
                }
                n = n.map[c - 'a'];
            }
            n.word = w;
        }

        return root;
    }
    
    /**
     * TrieNode class
     */
    class TrieNode {
        public TrieNode[] map = null;
        public String word;

        public TrieNode() {
            this.map = new TrieNode[26];
            this.word = null;
        }
    }

    private void printTrieNode(TrieNode root) {
        if (root == null) {
            return;
        }

        System.out.println(Arrays.toString(root.map));
        for (int i = 0; i < 26; ++i) {
            printTrieNode(root.map[i]);
        }
    }

    /**
     * Main
     */
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

        WordSearchIIv2 ws = new WordSearchIIv2();
        List<String> list = ws.findWords(board, words);
        System.out.println("Output: " + list.toString());
    }

    /**
     * Prints the given matrix
     */
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
