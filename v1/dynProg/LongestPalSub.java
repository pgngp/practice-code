/**
 * Longest palindromic substring (170):
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 */

/*
 * time: O(n^2)
 * space: O(1)
 */
public class LongestPalSub {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int startPos = 0;
        int endPos = 0;
        int maxLen = endPos - startPos + 1;
        for (int i = 0; i < s.length(); ++i) {
            int len = getLen(s, i, i);
            if (len > maxLen) {
                startPos = i - (len / 2);
                endPos = i + (len / 2);
                maxLen = endPos - startPos + 1;
            }

            len = getLen(s, i, i + 1);
            if (len > maxLen) {
                startPos = i - (len / 2) + 1;
                endPos = i + (len / 2);
                maxLen = endPos - startPos + 1;
            }
        }

        return s.substring(startPos, endPos + 1);
    }

    private int getLen(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }

        return j - i - 1;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java prog <s>");
            System.exit(1);
        }

        String s = args[0];
        LongestPalSub lps = new LongestPalSub();
        String longestPal = lps.longestPalindrome(s);
        System.out.println("lps: " + longestPal);
    }
}
