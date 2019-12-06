/**
 * Wildcard matching (96):
 * Implement wildcard pattern matching with support for '?' and '*'.
 * http://www.programcreek.com/2014/06/leetcode-wildcard-matching-java/
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * Ex:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 *
 * Ex: 
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */

import java.util.Arrays;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        // create table
        boolean[][] m = new boolean[pl + 1][sl + 1];
        m[0][0] = true;
        
        // first col
        for (int i = 1; i < m.length; ++i) {
            if (p.charAt(i - 1) == '*') {
                m[i][0] = m[i - 1][0];
            }
        }

        // remaining cols
        for (int row = 1; row < m.length; ++row) {
            char x = p.charAt(row - 1);
            for (int col = 1; col < m[0].length; ++col) {
                char y = s.charAt(col - 1);
                if (x >= 'a' && y <= 'z') {
                    m[row][col] = (x == y && m[row - 1][col - 1]);
                } else if (x == '?') { // x = '?'
                    m[row][col] = m[row - 1][col - 1];
                } else { // x = '*'
                    m[row][col] = m[row][col - 1] || m[row - 1][col - 1] || m[row - 1][col];
                }
            }
        }
        
        return m[pl][sl];
    }

    private void printMatrix(boolean[][] m) {
        System.out.println("matrix:");
        System.out.println("[");
        for (int row = 0; row < m.length; ++row) {
            System.out.print("  [ ");
            for (int col = 0; col < m[0].length; ++col) {
                char c = m[row][col] ? 'T' : 'F';
                System.out.print(c + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <string> <pattern>");
            System.exit(1);
        }

        String s = args[0];
        String p = args[1];
        System.out.println("s: " + s);
        System.out.println("p: " + p);

        WildcardMatching wm = new WildcardMatching();
        boolean result = wm.isMatch(s, p);
        System.out.println("result: " + result);
    }
}
