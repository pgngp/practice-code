/**
 * Regular expression matching (165):
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * Example 1:
 * s = "aa"
 * p = "a"
 * Output: false
 *
 * Example 2:
 * s = "aa"
 * p = "a*"
 * Output: true
 *
 * Example 3:
 * s = "ab"
 * p = ".*"
 * Output: true
 *
 * Example 4:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * 
 * Example 5:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 */

/*
 * time: O(mn)
 * space: O(mn)
 */

public class RegExpMatching {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] t = new boolean[pl + 1][sl + 1];
        t[0][0] = true;

        // first col
        for (int row = 1; row < t.length; ++ row) {
            t[row][0] = (p.charAt(row - 1) == '*' && t[row - 2][0]);
        }

        // remaining cols
        char cp = '-';
        for (int row = 1; row <= pl; ++row) {
            char cc = p.charAt(row - 1);
            for (int col = 1; col <= sl; ++col) {
                char d = s.charAt(col - 1);
                if (cc == '*') {
                    t[row][col] = ((cp == '.' || cp == d) && (t[row][col - 1] || t[row - 1][col]) || t[row - 2][col]);
                } else if (cc == '.') {
                    t[row][col] = t[row - 1][col - 1];
                } else {
                    t[row][col] = (cc == d && t[row - 1][col - 1]);
                }
            }
            cp = cc;
        }

        return t[pl][sl];
    }

    private void printMatrix(boolean[][] t) {
        System.out.println("[");
        for (int row = 0; row < t.length; ++row) {
            System.out.print("  [ ");
            for (int col = 0; col < t[0].length; ++col) {
                char c = t[row][col] ? 'T' : 'F';
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

        RegExpMatching rem = new RegExpMatching();
        boolean result = rem.isMatch(s, p);
        System.out.println("result: " + result);
    }
}
