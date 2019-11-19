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

public class WordLadderIIv3 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> notVisited = new HashSet<>();
        for (String w : wordList) {
            notVisited.add(w);
        }
        if (!notVisited.contains(endWord)) {
            return result;
        }
        notVisited.remove(beginWord);
        notVisited.remove(endWord);

        Map<String, Set<String>> map = new HashMap<>();
        int min = helper(beginWord, endWord, notVisited, map);
        System.out.println("map: " + map);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        createResult(beginWord, endWord, map, result, list, min);

        return result;
    }

    private int helper(String beginWord, String endWord, Set<String> notVisited, Map<String, Set<String>> map) {
        List<String> visited = new ArrayList<>();
        visited.add(beginWord);
        int start = 0;
        int end = 1;
        int min = Integer.MAX_VALUE;
        int steps = 1;
        List<String> tmpNotVisited = new ArrayList<>();
        while (start < end) {
            ++steps;
            if (steps > min) {
                break;
            }
            for (int i = start; i < end; ++i) {
                String word = visited.get(i);
                if (word.equals(endWord)) {
                    continue;
                }
                if (!map.containsKey(word)) {
                    map.put(word, new HashSet<String>());
                }
                char[] arr = word.toCharArray();
                boolean isEndWord = false;
                for (int pos = 0; pos < arr.length; ++pos) {
                    char orig = arr[pos];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == orig) {
                            continue;
                        }
                        arr[pos] = c;
                        String newWord = new String(arr);
                        isEndWord = newWord.equals(endWord);
                        if (isEndWord) {
                            min = Math.min(min, steps);
                        } else if (!notVisited.contains(newWord)) {
                            continue;
                        }
                        visited.add(newWord);
                        tmpNotVisited.add(newWord);
                        map.get(word).add(newWord);
                    }
                    if (isEndWord) {
                        break;
                    }
                    arr[pos] = orig;
                }
            }
            start = end;
            end = visited.size();

            for (String w : tmpNotVisited) {
                notVisited.remove(w);
            }
            tmpNotVisited.clear();
        }
        
        return min;
    }

    private void createResult(String word, String endWord, Map<String, Set<String>> map, List<List<String>> result, List<String> list, int min) {
        if (!map.containsKey(word) || map.get(word).size() == 0) {
            if (word.equals(endWord) && list.size() == min) {
                result.add(new ArrayList<String>(list));
            }
            return;
        }

        Set<String> nextSet = map.get(word);
        for (String w : nextSet) {
            list.add(w);
            createResult(w, endWord, map, result, list, min);
            list.remove(w);
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

        WordLadderIIv3 wl = new WordLadderIIv3();
        List<List<String>> result = wl.findLadders(begin, end, dict);
        System.out.println("result: " + result);
    }
}
