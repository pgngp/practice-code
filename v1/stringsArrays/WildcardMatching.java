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

/*
 * time: O(mn)
 * space: O(s)
 */

import java.util.Arrays;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        boolean[] m = new boolean[sl + 1];
        m[0] = true;

        for (int row = 1; row <= p.length(); ++row) {
            char x = p.charAt(row - 1);
            boolean left = (x == '*' && m[0]);
            for (int col = 1; col <= sl; ++col) {
                boolean curr = false;
                if (x == '*') {
                    curr = left || m[col];
                } else if (x == '?') {
                    curr = m[col - 1];
                } else {
                    curr = (x == s.charAt(col - 1) && m[col - 1]);
                }
                m[col - 1] = left;
                left = curr;
            }
            m[sl] = left;
        }

        return m[sl];
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
