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

/*
 * time: O(n^2*m), where n is size of word list and m is size of each word
 * space: O(n*m)
 */

public class WordLadderIIv3 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> notVisited = new HashSet<>();
        notVisited.addAll(wordList);
        if (!notVisited.contains(endWord)) {
            return result;
        }
        notVisited.remove(beginWord);
        notVisited.remove(endWord);

        Map<String, Set<String>> map = new HashMap<>();
        helper(beginWord, endWord, notVisited, map);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        createResult(beginWord, endWord, map, result, list);

        return result;
    }

    private void helper(String beginWord, String endWord, Set<String> notVisited, Map<String, Set<String>> map) {
        List<String> visited = new ArrayList<>();
        visited.add(beginWord);
        boolean endWordReached = false;
        while (visited.size() > 0) {
            List<String> newVisited = new ArrayList<>();
            for (int i = 0; i < visited.size(); ++i) {
                String word = visited.get(i);
                Set<String> nextSet = new HashSet<String>();
                map.put(word, nextSet);
                char[] arr = word.toCharArray();
                for (int pos = 0; pos < arr.length; ++pos) {
                    char orig = arr[pos];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        arr[pos] = c;
                        String newWord = new String(arr);
                        if (newWord.equals(endWord)) {
                            endWordReached = true;
                            nextSet.add(newWord);
                            break;
                        } else if (notVisited.contains(newWord)) {
                            newVisited.add(newWord);
                            nextSet.add(newWord);
                        }
                    }
                    arr[pos] = orig;
                }
            }
            if (endWordReached) {
                break;
            }
            notVisited.removeAll(newVisited);
            visited = newVisited;
        }
    }

    private void createResult(String word, String endWord, Map<String, Set<String>> map, List<List<String>> result, List<String> list) {
        if (word.equals(endWord)) {
            result.add(new ArrayList<String>(list));
            return;
        } else if (!map.containsKey(word)) {
            return;
        }

        Set<String> nextSet = map.get(word);
        for (String w : nextSet) {
            list.add(w);
            createResult(w, endWord, map, result, list);
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

        WordLadderIIv3 wl = new WordLadderIIv3();
        List<List<String>> result = wl.findLadders(begin, end, dict);
        System.out.println("result: " + result);
    }
}
