/**
 * Anagrams (134):
 * Given an array of strings, return all groups of strings that are anagrams.
 * Analysis
 * An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase, using all the original letters exactly once; for example Torchwood can be rearranged into Doctor Who.
 * http://www.programcreek.com/2014/04/leetcode-anagrams-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedStr, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        List<List<String>> result = a.groupAnagrams(args);
        System.out.println("result: " + result);
    }
}
