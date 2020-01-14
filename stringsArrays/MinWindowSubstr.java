/**
 * Minimum window substring (99):
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 * http://www.programcreek.com/2014/05/leetcode-minimum-window-substring-java/
 */

import java.util.*;

public class MinWindowSubstr {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        String result = "";
        if (sl < tl) {
            return result;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tl; ++i) {
            char c = t.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            map.put(c, 0);
        }

        int i = 0, j = 0, min = Integer.MAX_VALUE, count = 0;
        while (i <= j && j < sl) {
            //System.out.println("i: " + i + ", j: " + j);
            while (j < sl && count < tl) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    if (map.get(c) < countMap.get(c)) {
                        ++count;
                    }
                    map.put(c, map.get(c) + 1);
                }
                ++j;
            }
            --j;

            if (count < tl) {
                break;
            } else if (min > j - i + 1) {
                min = j - i + 1;
                result = s.substring(i, j + 1);
            }
            //System.out.println("  j: " + j + ", count: " + count);

            while (i <= j && count == tl) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c) == countMap.get(c)) {
                        --count;
                    }
                    map.put(c, map.get(c) - 1);
                }

                if (min > j - i + 1) {
                    min = j - i + 1;
                    result = s.substring(i, j + 1);
                }
                ++i;
            }

            while (i <= j && !countMap.containsKey(s.charAt(i))) {
                ++i;
            }
            //System.out.println("  i: " + i + ", count: " + count);
            ++j;
        }

        return result;
    }

    public static void main(String[] args) {
        MinWindowSubstr mws = new MinWindowSubstr();
        System.out.println("s: " + args[0] + ", t: " + args[1]);
        String result = mws.minWindow(args[0], args[1]);
        System.out.println("result: " + result);
    }
}
