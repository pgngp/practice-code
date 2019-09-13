/**
 * Word break II (172):
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences. For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
 * http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
 */

/*
 * - create an array where index is position and value is list of words
 * - start from the first position; for each word in that position, add the sentence to the list
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // create index
        List<String>[] wordPos = new ArrayList[s.length() + 1];
        wordPos[0] = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            if (wordPos[i] == null) {
                continue;
            }

            for (int j = 0; j < wordDict.size(); ++j) {
                String w = wordDict.get(j);
                int end = i + w.length();
                if (end <= s.length() && w.equals(s.substring(i, end))) {
                    wordPos[end] = wordPos[end] != null ? wordPos[end] : new ArrayList<>();
                    wordPos[end].add(w);
                }
            }
        }

        // construct list
        List<String> result = new ArrayList<>();
        if (wordPos[s.length()] == null) {
            return result;
        }

        List<String> tmp = new ArrayList<>();
        dfs(wordPos, s.length(), tmp, result);

        return result;
    }

    private void dfs(List<String>[] wordPos, int pos, List<String> tmp, List<String> result) {
        if (pos <= 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = tmp.size() - 1; i > 0; --i) {
                sb.append(tmp.get(i)).append(" ");
            }
            sb.append(tmp.get(0));
            result.add(sb.toString());
            return;
        }
    
        for (String w : wordPos[pos]) {
            tmp.add(w);
            dfs(wordPos, pos - w.length(), tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void printWordPos(List<Integer>[] wordPos) {
        System.out.println("WordPos:");
        for (int i = 0; i < wordPos.length; ++i) {
            System.out.printf("%d: ", i);
            if (wordPos[i] == null) {
                System.out.println("");
                continue;
            }
            for (int j = 0; j < wordPos[i].size(); ++j) {
                System.out.printf("%s ", wordPos[i].get(j));
            }
            System.out.println("");
        }
        System.out.println("");
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

        WordBreakII wb = new WordBreakII();
        List<String> result = wb.wordBreak(s, dict);
        System.out.println(result);
    }
}
