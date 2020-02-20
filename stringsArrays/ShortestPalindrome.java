/**
 * Shortest palindrome (96):
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd".
 * http://www.programcreek.com/2014/06/leetcode-shortest-palindrome-java/
 */

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0, end = n - 1, j = end;
        String prefix = "";
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                i = 0;
                prefix += s.charAt(end);
                --end;
                j = end;
            } else {
                ++i;
                --j;
            }
        }

        return prefix + s;
    }

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        String result = sp.shortestPalindrome(args[0]);
        System.out.println("result: " + result);
    }
}
