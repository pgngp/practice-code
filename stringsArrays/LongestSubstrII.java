/**
 * Longest substring that contains 2 unique characters (33):
 * This is a problem asked by Google.
 * Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
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
            if (map.containsKey(c) || map.size() < 2) {
                ++count;
            } else {
                max = Math.max(max, count);
                Iterator<Character> it = map.keySet().iterator();
                char x = ' ';
                while (it.hasNext()) {
                    x = it.next();
                    if (x != s.charAt(i - 1)) {
                        break; 
                    }
                }
                count = i - map.get(x);
                map.remove(x);
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
