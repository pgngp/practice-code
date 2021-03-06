/**
 * Longest substring without repeating characters (257):
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class LongestSubstr {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int[] arr = new int[127];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = -1;
        }

        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            int idx = c - '\u0000';
            if (i - count <= arr[idx]) {
                max = Math.max(max, count);
                count = i - arr[idx];
            } else {
                ++count;
            }
            arr[idx] = i;
        }
        max = Math.max(max, count);

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c) && i - count <= map.get(c)) {
                max = Math.max(max, count);
                count = i - map.get(c);
            } else {
                ++count;
            }
            map.put(c, i);
        }
        max = Math.max(max, count);

        return max;
    }

    public static void main(String[] args) {
        LongestSubstr ls = new LongestSubstr();
        int result = ls.lengthOfLongestSubstring(args[0]);
        System.out.println("result: " + result);
    }
}
