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
        int slen = s.length();
        int[] cache = new int[s.length()];

        // last digit
        if (s.charAt(slen - 1) == '0') {
            cache[slen - 1] = 0;
        } else {
            cache[slen - 1] = 1;
        }

        // second-last digit
        if (slen - 2 < 0) {
            return cache[0];
        } else if (s.charAt(slen - 2) == '0') {
            cache[slen - 2] = 0;
        } else if (Integer.parseInt(s.substring(slen - 2, slen)) <= 26) {
            cache[slen - 2] = 1 + cache[slen - 1];
        } else {
            cache[slen - 2] = cache[slen - 1];
        }

        // remaining
        for (int i = slen - 3; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                cache[i] = 0;
            } else if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                cache[i] = cache[i + 1] + cache[i + 2];
            } else {
                cache[i] = cache[i + 1];
            }
        }

        return cache[0];
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
