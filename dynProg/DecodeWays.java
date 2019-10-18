/**
 * Decode ways (110):
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * …
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it
 * Ex1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Ex2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * http://www.programcreek.com/2014/06/leetcode-decode-ways-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

public class DecodeWays {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            cache[i] = -1;
        }

        return helper(s, 0, 1, cache) + helper(s, 0, 2, cache);
    }

    private int helper(String s, int pos, int numDigits, int[] cache) {
        int end = pos + numDigits;
        if (s.charAt(pos) == '0' || end > s.length() || Integer.parseInt(s.substring(pos, end)) > 26) {
            return 0;
        } else if (end == s.length()) {
            return 1;
        } else if (cache[end] == -1) {
            cache[end] = helper(s, end, 1, cache) + helper(s, end, 2, cache);
        }

        return cache[end];
    }

    private void printArr(int[] m) {
        System.out.print("[ ");
        for (int i = 0; i < m.length; ++i) {
            System.out.print(m[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <digits>");
            System.exit(1);
        }

        DecodeWays dw = new DecodeWays();
        int result = dw.numDecodings(args[0]);
        System.out.println("result: " + result);
    }
}
