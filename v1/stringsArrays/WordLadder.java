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

/*
 * time: O(n * m), where n is size of word list and m is size of each word
 * space: O(n * m)
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

        int maxHops = wordList.size() + 2;
        int result = 1 + helper(beginWord, notVisited, visitedList, 0, maxHops);

        return result >= maxHops ? 0 : result;
    }

    private int helper(String beginWord, Set<String> notVisited, List<String> visitedList, int startIdx, int maxHops) {
        int visitedListSize = visitedList.size();
        if (startIdx >= visitedListSize) {
            return maxHops;
        }

        for (int i = startIdx; i < visitedListSize; ++i) {
            char[] charArr = visitedList.get(i).toCharArray();
            for (int pos = 0; pos < charArr.length; ++pos) {
                char orig = charArr[pos];
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == orig) {
                        continue;
                    }
                    charArr[pos] = c;
                    String newWord = new String(charArr);
                    if (newWord.equals(beginWord)) {
                        return 1;
                    } else if (!notVisited.contains(newWord)) {
                        continue;
                    }
                    notVisited.remove(newWord);
                    visitedList.add(newWord);
                }
                charArr[pos] = orig;
            }
        }

        return 1 + helper(beginWord, notVisited, visitedList, visitedListSize, maxHops);
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
