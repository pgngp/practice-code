/**
 * Distinct subsequences total (65):
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * http://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/
 */

public class Subsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int sl = s.length();
        int tl = t.length();
        int[] m = new int[sl + 1];
        for (int col = 0; col <= sl; ++col) {
            m[col] = 1;
        }

        for (int row = 1; row <= tl; ++row) {
            int left = 0;
            int curr = 0;
            char tc = t.charAt(row - 1);
            for (int col = 1; col <= sl; ++col) {
                if (tc == s.charAt(col - 1)) {
                    curr = m[col - 1] + left;
                } else {
                    curr = left;
                }
                m[col - 1] = left;
                left = curr;
            }
            m[sl] = curr;
        }

        return m[sl];
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java <prog> <s> <t>");
            System.exit(1);
        }

        String s = args[0];
        String t = args[1];
        Subsequences subseq = new Subsequences();
        int count = subseq.numDistinct(s, t);
        System.out.println("count: " + count);
    }
}

