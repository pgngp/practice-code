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

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>();
        for (String w : wordList) {
            notVisited.add(w);
        }
        if (!notVisited.contains(endWord)) {
            return null;
        }
        notVisited.remove(endWord);
     
        List<String> visited = new ArrayList<>();
        visited.add(endWord);

        Integer min = Integer.MAX_VALUE;
        
        Map<String, List<String>> map = new HashMap<>();
        map.put(beginWord, new ArrayList<String>());
        helper(beginWord, notVisited, visited, 0, 1, min, map);

        List<String> currList = new ArrayList<>();
        currList.add(beginWord);
        List<List<String>> result = new ArrayList<>();
        addToResult(beginWord, result, currList, map);
               
        return result;
    }
    
    private void addToResult(String word, List<List<String>> result, List<String> currList, Map<String, List<String>> map) {
        if (!map.containsKey(word)) {
            result.add(new ArrayList<>(currList));
            return;
        }

        List<String> prevList = map.get(word);
        //System.out.println("prevList: " + prevList);
        for (int i = 0; i < prevList.size(); ++i) {
            String thisWord = prevList.get(i);
            //System.out.println("thisWord: " + thisWord);
            currList.add(thisWord);
            addToResult(thisWord, result, currList, map);
            currList.remove(thisWord);
        }
    }

    private void helper(String beginWord, Set<String> notVisited, List<String> visited, int startIdx, int distance, Integer min, Map<String, List<String>> map) {
        int visitedSize = visited.size();
        if (startIdx >= visitedSize) {
            return;
        }

        System.out.print("visited: ");
        for (int i = startIdx; i < visitedSize; ++i) {
            String word = visited.get(i);
            System.out.print(word + " ");
            char[] arr = word.toCharArray();
            for (int pos = 0; pos < arr.length; ++pos) {
                char orig = arr[pos];
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == orig) {
                        continue;
                    }
                    arr[pos] = c;
                    String newWord = new String(arr);
                    if (newWord.equals(beginWord)) {
                        if (min > distance) {
                            min = distance;
                            List<String> prevList = map.get(beginWord);
                            prevList.clear();
                            prevList.add(word);
                        } else if (min == distance) {
                            List<String> prevList = map.get(beginWord);
                            prevList.add(word);
                        }
                        break;
                    } else if (!notVisited.contains(newWord)) {
                        continue;
                    }
                    notVisited.remove(newWord);
                    visited.add(newWord);
                    if (!map.containsKey(newWord)) {
                        map.put(newWord, new ArrayList<>());
                    }
                    List<String> prevList = map.get(newWord);
                    prevList.add(word);
                }
                arr[pos] = orig;
            }
        }
        System.out.println();

        helper(beginWord, notVisited, visited, visitedSize, distance + 1, min,  map);
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

        WordLadderII wl = new WordLadderII();
        List<List<String>> result = wl.findLadders(begin, end, dict);
        System.out.println("result: " + result);
    }
}
