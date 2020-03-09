/**
 * Shortest palindrome (96):
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd".
 * http://www.programcreek.com/2014/06/leetcode-shortest-palindrome-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        
        String rev = new StringBuilder(s).reverse().toString();
        int suffixLen = getSuffixLength(s + "#" + rev);
        String prefix = rev.substring(0, n - suffixLen);

        return prefix + s;
    }

    private int getSuffixLength(String s) {
        int n = s.length();
        int[] arr = new int[n];
        arr[0] = 0;
        int i = 0, j = 1;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                arr[j] = i + 1;
                ++i;
                ++j;
            } else if (i == 0) {
                arr[j] = 0;
                ++j;
            } else {
                i = arr[i - 1];
            }
        }

        return arr[n - 1];
    }

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        String result = sp.shortestPalindrome(args[0]);
        System.out.println("result: " + result);
    }
}
