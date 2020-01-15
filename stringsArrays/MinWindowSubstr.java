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

        // refmap
        Map<Character, Integer> refMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tl; ++i) {
            char c = t.charAt(i);
            refMap.put(c, refMap.getOrDefault(c, 0) + 1);
            map.put(c, 0);
        }

        int i = 0, j = 0, min = Integer.MAX_VALUE, count = 0;
        Deque<Integer> q = new ArrayDeque<>();
        while (j < sl) {
            char c = s.charAt(j);
            if (refMap.containsKey(c)) {
                if (map.get(c) < refMap.get(c)) {
                    ++count;
                }
                map.put(c, map.getOrDefault(c, 0) + 1);
                q.addLast(j);
            }
            ++j;

            if (count < tl) {
                continue;
            }

            if (min > j - i) {
                min = j - i;
                result = s.substring(i, j);
            }

            while (q.size() > 0 && count == tl) {
                i = q.removeFirst();
                char d = s.charAt(i);
                if (map.get(d) <= refMap.get(d)) {
                    --count;
                }

                if (min > j - i) {
                    min = j - i;
                    result = s.substring(i, j);
                }
                map.put(d, map.get(d) - 1);
            }
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
