/**
 * Palindrome partitioning II (69):
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s. For example, given s = "aab", return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * http://www.programcreek.com/2014/04/leetcode-palindrome-partitioning-ii-java/
 */

/*
 * time: O(n^2)
 * space: O(n^2)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int slen = s.length();
        boolean[][] pal = new boolean[slen][slen];
        int[] cut = new int[slen + 1];
        cut[slen] = -1;
        for (int i = slen - 1; i >= 0; --i) {
            int min = slen - i + 1;
            for (int j = i; j < slen; ++j) {
               if (s.charAt(i) == s.charAt(j) && (i + 1 >= j || pal[i + 1][j - 1])) {
                   pal[i][j] = true;
                   min = Math.min(min, cut[j + 1] + 1);
               }
            }
            cut[i] = min;
        }

        return cut[0];
    }

    private void printArr(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private void printMatrix(boolean[][] m) {
        System.out.println("[");
        for (int row = 0; row < m.length; ++row) {
            System.out.print("  [ ");
            for (int col = 0; col < m[0].length; ++col) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java prog <s>");
            System.exit(1);
        }

        PalindromePartitioningII pp = new PalindromePartitioningII();
        int result = pp.minCut(args[0]);
        System.out.println("result: " + result);
    }
}
