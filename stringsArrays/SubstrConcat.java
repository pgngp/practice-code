/**
 * Substring with concatenation of all words (110):
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9].
 * http://www.programcreek.com/2014/06/leetcode-substring-with-concatenation-of-all-words-java/
 */

import java.util.*;

public class SubstrConcat {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int numWords = words.length;
        if (n == 0 || numWords == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String item : words) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        int wordLen = words[0].length();
        int i = 0, j = wordLen;
        while (j <= n) {
            if (map.containsKey(s.substring(i, j))) {
                Map<String, Integer> copy = new HashMap<>(map);
                helper(s, copy, result, i, wordLen, numWords);
            }
            ++i;
            ++j;
        }

        return result;
    }

    private void helper(String s, Map<String, Integer> map, List<Integer> result, int pos, int len, int numWords) {
        int start = pos;
        int end = start + len;
        int count = 0;
        while (end <= s.length()) {
            String substr = s.substring(start, end);
            if (map.containsKey(substr) && map.get(substr) > 0) {
                start = end;
                end = start + len;
                map.put(substr, map.get(substr) - 1);
                ++count;
            } else if (count == numWords) {
                break;
            } else {
                return;
            }
        }

        if (count == numWords) {
            result.add(pos);
        }
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
