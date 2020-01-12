/**
 * Longest substring that contains 2 unique characters (33):
 * This is a problem asked by Google.
 * Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class LongestSubstrII {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.size() < 2 || map.containsKey(c)) {
                ++count;
            } else {
                max = Math.max(max, count);
                int tmp = Collections.min(map.values());
                count = i - tmp;
                map.remove(s.charAt(tmp));
            }
            map.put(c, i);
        }
        max = Math.max(max, count);

        return max;
    }

    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if (s.length() <= 2) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, count = 0;
        char p1 = ' ', p2 = ' ';
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                ++count;
                if (c != p2) {
                    p1 = p2;
                    p2 = c;
                }
            } else if (map.size() < 2) {
                ++count;
                if (p1 == ' ') {
                    p1 = c;
                } else {
                    p2 = c;
                }
            } else {
                max = Math.max(max, count);
                count = i - map.get(p1);
                map.remove(p1);
                p1 = p2;
                p2 = c;
            }
            map.put(c, i);
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
