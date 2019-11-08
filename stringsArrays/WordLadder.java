/**
 * Word ladder (153):
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary.
 * For example, given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 * http://www.programcreek.com/2012/12/leetcode-word-ladder/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>();
        for (String w : wordList) {
            notVisited.add(w);
        }

        if (!notVisited.contains(endWord)) {
            return 0;
        }

        List<String> visitedList = new ArrayList<>();
        visitedList.add(endWord);
        notVisited.remove(endWord);

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int result = helper(beginWord, notVisited, letters, 1, visitedList, 0);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int helper(String beginWord, Set<String> notVisited, char[] letters, int distance, List<String> visitedList, int startIdx) {
        int visitedListSize = visitedList.size();
        if (startIdx >= visitedListSize) {
            return Integer.MAX_VALUE;
        }

        for (int i = startIdx; i < visitedListSize; ++i) {
            String word = visitedList.get(i);
            char[] charArr = word.toCharArray();
            for (int pos = 0; pos < word.length(); ++pos) {
                char orig = charArr[pos];
                for (char c : letters) {
                    charArr[pos] = c;
                    String newWord = new String(charArr);
                    if (newWord.equals(beginWord)) {
                        return distance + 1;
                    } else if (!notVisited.contains(newWord)) {
                        continue;
                    }
                    notVisited.remove(newWord);
                    visitedList.add(newWord);
                }
                charArr[pos] = orig;
            }
        }

        return helper(beginWord, notVisited, letters, distance + 1, visitedList, visitedListSize);
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>();
        for (String w : wordList) {
            notVisited.add(w);
        }

        if (!notVisited.contains(endWord)) {
            return 0;
        }
        notVisited.remove(endWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(endWord);
        
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Map<String, Integer> cache = new HashMap<>();
        cache.put(endWord, 1);
        cache.put(beginWord, Integer.MAX_VALUE);
        
        //int result = 1 + helper5(beginWord, visited, notVisited, letters, 1);
        //return result;
        notVisited.remove(beginWord);
        helper2(beginWord, visited, notVisited, letters, 1, cache);
        return cache.get(beginWord) == Integer.MAX_VALUE ? 0 : cache.get(beginWord);
    }

    private void helper2(String beginWord, Set<String> visited, Set<String> notVisited, char[] letters, int distance, Map<String, Integer> cache) {
        Set<String> newSet = new HashSet<>();
        Iterator iter = notVisited.iterator();
        int setSize = notVisited.size();
        while (iter.hasNext()) {
            String word = (String) iter.next();
            boolean transformable = isTransformable(word, beginWord);
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                char orig = arr[i];
                for (char c : letters) {
                    if (c == orig) {
                        continue;
                    }
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (!cache.containsKey(newWord) || newWord.equals(beginWord)) {
                        continue;
                    }
                    if (transformable) {
                        int min = Math.min(cache.get(beginWord), cache.get(newWord) + 2);
                        cache.put(beginWord, min);
                    }
                    cache.put(word, cache.get(newWord) + 1);
                }
                arr[i] = orig;
            }

            if (cache.containsKey(word)) {
                iter.remove();
            }
        }

        if (notVisited.size() < setSize) {
            helper2(beginWord, newSet, notVisited, letters, distance + 1, cache);
        }
    }

    private boolean isTransformable(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); ++i) {
            if (w1.charAt(i) == w2.charAt(i)) {
                continue;
            }
            ++diff;
            if (diff > 1) {
                return false;
            }
        }

        return true;
    }

    private int helper5(String beginWord, Set<String> visited, Set<String> notVisited, char[] letters, int distance) {
        Set<String> newSet = new HashSet<>();
        Iterator iter = visited.iterator();
        while (iter.hasNext()) {
            String word = (String) iter.next();
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                char orig = arr[i];
                for (char c : letters) {
                    if (c == orig) {
                        continue;
                    }
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (newWord.equals(beginWord)) {
                        return 1;
                    }
                    if (!notVisited.contains(newWord)) {
                        continue;
                    }
                    newSet.add(newWord);
                    notVisited.remove(newWord);
                }
                arr[i] = orig;
            }
        }

        return visited.size() == 0 ? -distance : 1 + helper5(beginWord, newSet, notVisited, letters, distance + 1);
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

        WordLadder wl = new WordLadder();
        int result = wl.ladderLength(begin, end, dict);
        System.out.println("result: " + result);
    }
}
