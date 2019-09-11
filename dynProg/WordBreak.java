/**
 * Word break (178):
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * http://www.programcreek.com/2012/12/leetcode-solution-word-break/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * time: O(n^2)
 * space: O(n)
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length() + 1];
        arr[0] = true;

        int slen = s.length();
        for (int i = 0; i < slen; ++i) {
            if (!arr[i]) {
                continue;
            }

            for (String word : wordDict) {
                int end = i + word.length();
                if (slen < end || arr[end]) {
                    continue;
                } else if (word.equals(s.substring(i, end))) {
                    arr[end] = true;
                }
            }
        }

        return arr[s.length()];
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java prog <s> <# dict> <dict word1> <dict word2>...");
            System.exit(1);
        }

        String s = args[0];
        int numWords = Integer.parseInt(args[1]);
        List<String> dict = new ArrayList<>();
        for (int i = 2; i < args.length; ++i) {
            dict.add(args[i]);
        }

        WordBreak wb = new WordBreak();
        boolean result = wb.wordBreak(s, dict);
        System.out.println(result);
    }
}

