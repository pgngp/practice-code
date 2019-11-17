/**
 * Word ladder II (120):
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that: 1) Only one letter can be changed at a time, 2) Each intermediate word must exist in the dictionary.
 * For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class WordLadderIIv2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String w : wordList) {
            set.add(w);
        }
        if (!set.contains(endWord)) {
            return result;
        }
        set.remove(beginWord);

        List<String> currList = new ArrayList<>();
        currList.add(beginWord);
        dfs(endWord, beginWord, set, result, currList);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); ++i) {
            min = Math.min(min, result.get(i).size());
        }
        Iterator<List<String>> iter = result.iterator();
        while (iter.hasNext()) {
            if (iter.next().size() > min) {
                iter.remove();
            }
        }

        return result;
    }

    private void dfs(String endWord, String currWord, Set<String> set, List<List<String>> result, List<String> currList) {
        if (currWord.equals(endWord)) {
            result.add(new ArrayList<String>(currList));
            return;
        }

        char[] arr = currWord.toCharArray();
        for (int pos = 0; pos < arr.length; ++pos) {
            char orig = arr[pos];
            for (char c = 'a'; c <= 'z'; ++c) {
                if (c == orig) {
                    continue;
                }
                arr[pos] = c;
                String newWord = new String(arr);
                if (!set.contains(newWord)) {
                    continue;
                }
                set.remove(newWord);
                currList.add(newWord);
                dfs(endWord, newWord, set, result, currList);
                currList.remove(newWord);
                set.add(newWord);
            }
            arr[pos] = orig;
        }
    }
    
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <beginword> <endword> <n> <dict1> <dict2> ...");
            System.exit(1);
        }

        String begin = args[0];
        String end = args[1];
        int n = Integer.parseInt(args[2]);
        List<String> dict = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            dict.add(args[i + 3]);
        }
        //System.out.println("dict: " + dict.toString());

        WordLadderIIv2 wl = new WordLadderIIv2();
        List<List<String>> result = wl.findLadders(begin, end, dict);
        System.out.println("result: " + result);
    }
}
