/**
 * Longest substring that contains 2 unique characters (33):
 * This is a problem asked by Google.
 * Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 */

import java.util.*;

public class LongestSubstrII {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n <= 2) {
            return n;
        }

        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> q = new ArrayDeque<>();
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, i);
                ++count;
            } else if (map.size() < 2) {
                map.put(c, i);
                ++count;
                q.addLast(c);
            } else {
                char x = q.removeFirst();
                if (x == s.charAt(i - 1)) {
                    q.addLast(x);
                    x = q.removeFirst();
                }
                max = Math.max(max, count);
                count = i - map.get(x);
                map.remove(x);
                map.put(c, i);
                q.addLast(c);
            }
        }
        max = Math.max(max, count);

        return max;
    }

    public static void main(String[] args) {
        LongestSubstrII ls = new LongestSubstrII();
        int result = ls.lengthOfLongestSubstringTwoDistinct(args[0]);
        System.out.println("result: " + result);
    }
}
