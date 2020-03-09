/**
 * Palindrome partitioning (118):
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
 */

/*
 * time: O(n^2)
 * space: O(n^3)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s == null) {
            return null;
        }

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(-1, new ArrayList<>());
        for (int i = 0; i < s.length(); ++i) {
            expand(s, i, i, map);
            expand(s, i, i + 1, map);
        }
        //System.out.println("map: " + map);

        Map<String, List<List<String>>> map2 = new HashMap<>();
        List<List<String>> listOfList = new ArrayList<>();
        listOfList.add(new ArrayList<String>());
        map2.put("", listOfList);
        for (int i = 0; i < s.length(); ++i) {
            helper(s, i, map, map2);
        }
        //System.out.println("map2: " + map2);

        return map2.get(s);
    }

    private void expand(String s, int i, int j, Map<Integer, List<String>> map) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (!map.containsKey(j)) {
                map.put(j, new ArrayList<String>());
            }
            List<String> list = map.get(j);
            list.add(s.substring(i, j + 1));
            --i;
            ++j;
        }
    }

    private void helper(String s, int pos, Map<Integer, List<String>> map, Map<String, List<List<String>>> map2) {
        List<List<String>> newListOfList = new ArrayList<>();
        for (String pal : map.get(pos)) {
            int end = pos - pal.length() + 1;
            List<List<String>> listOfList = map2.get(s.substring(0, end));
            for (List<String> list : listOfList) {
                List<String> tmpList = new ArrayList<String>(list);
                tmpList.add(pal);
                newListOfList.add(tmpList);
            }
        }

        map2.put(s.substring(0, pos + 1), newListOfList);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java prog <s>");
            System.exit(1);
        }

        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> result = pp.partition(args[0]);
        System.out.println("result: " + result);
    }
}
