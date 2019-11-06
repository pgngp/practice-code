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
        notVisited.remove(endWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(endWord);
        
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        int result = 1 + helper(beginWord, visited, notVisited, letters, 1);
        
        return result;
    }

    private int helper(String beginWord, Set<String> visited, Set<String> notVisited, char[] letters, int distance) {
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

        return visited.size() == 0 ? -distance : 1 + helper(beginWord, newSet, notVisited, letters, distance + 1);
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        //System.out.println("beginword: " + beginWord + ", endword: " + endWord);
        Set<String> set = new HashSet<>();
        for (String w : wordList) {
            set.add(w);
        }

        if (!set.contains(endWord)) {
            return 0;
        }
 
        Map<String, Integer> cache = new HashMap<>();
        cache.put(endWord, 1);
        int maxHops = wordList.size() + 2;
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int result = dfs(beginWord, set, cache, maxHops, letters);

        return result == maxHops ? 0 : result;
    }

    private int dfs(String beginWord, Set<String> set, Map<String, Integer> cache, int maxHops, char[] letters) {
        if (cache.containsKey(beginWord)) {
            return cache.get(beginWord);
        }

        char[] arr = beginWord.toCharArray();
        int min = maxHops;
        for (int i = 0; i < arr.length; ++i) {
            char orig = arr[i];
            for (char c : letters) {
                if (c == orig) {
                    continue;
                }
                arr[i] = c;
                String w = new String(arr);
                if (!set.contains(w)) {
                    continue;
                }
                set.remove(w);
                min = Math.min(min, 1 + dfs(w, set, cache, maxHops, letters));
                set.add(w);
            }
            arr[i] = orig;
        }
        //cache.put(beginWord, min);

        return min;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        } else if (isTransformable(beginWord, endWord)) {
            return 2;
        }

        int result = dfs2(beginWord, endWord, wordList, new HashSet<String>(), new HashMap<String, Integer>());

        return result == wordList.size() + 2 ? 0 : result;
    }

    private int dfs2(String beginWord, String endWord, List<String> wordList, Set<String> set, Map<String, Integer> cache) {
        if (beginWord.equals(endWord)) {
            return 1;
        } else if (cache.containsKey(beginWord)) {
            return cache.get(beginWord);
        }

        int min = wordList.size() + 2;
        for (String word : wordList) {
            if (set.contains(word) || !isTransformable(beginWord, word)) {
                continue;
            }
            set.add(word);
            min = Math.min(min, 1 + dfs2(word, endWord, wordList, set, cache));
            set.remove(word);
        }
        cache.put(beginWord, min);

        return min;
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
