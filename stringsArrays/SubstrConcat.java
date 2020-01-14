/**
 * Substring with concatenation of all words (110):
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9].
 * http://www.programcreek.com/2014/06/leetcode-substring-with-concatenation-of-all-words-java/
 */

/*
 * time: O(n * nw * wl)
 * space: O(nw * wl)
 */

import java.util.*;

public class SubstrConcat {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int numWords = words.length;
        if (n == 0 || numWords == 0 || n < numWords * words[0].length()) {
            return result;
        }
        
        // time: O(nw * wl); space: O(nw)
        Map<String, Integer> map = new HashMap<>();
        for (String item : words) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        // time: (n * nw * wl); space: O(nw * wl)
        int wordLen = words[0].length();
        int i = 0, j = wordLen;
        Map<String, Integer> map2 = new HashMap<>();
        while (j <= n) {
            String substr = s.substring(i, j);
            if (map.containsKey(substr)) {
                map2.putAll(map);
                map2.put(substr, map2.get(substr) - 1);
                if (helper(s, map2, j, wordLen) == numWords) {
                    result.add(i);
                }
                map2.clear();
            }
            ++i;
            ++j;
        }

        return result;
    }

    // time: O(nw * wl); space: O(wl)
    private int helper(String s, Map<String, Integer> map, int start, int len) {
        int end = start + len;
        int count = 1;
        while (end <= s.length()) {
            String substr = s.substring(start, end);
            if (map.containsKey(substr) && map.get(substr) > 0) {
                start = end;
                end = start + len;
                map.put(substr, map.get(substr) - 1);
                ++count;
            } else {
                break;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        String s = args[0];
        String[] words = new String[args.length - 1];
        for (int i = 0; i < words.length; ++i) {
            words[i] = args[i + 1];
        }
        System.out.println("s: " + s + ", words: " + Arrays.toString(words));

        SubstrConcat sc = new SubstrConcat();
        List<Integer> result = sc.findSubstring(s, words);
        System.out.println("result: " + result.toString());
    }
}
