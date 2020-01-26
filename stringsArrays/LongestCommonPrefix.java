/**
 * Longest common prefix (200):
 * Write a function to find the longest common prefix string amongst an array of strings.
 * http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/
 */

import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        int min = strs[0].length();
        for (String s : strs) {
            min = Math.min(min, s.length());
        }

        int i = 0;
        boolean stop = false;
        for (; i < min; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (c != strs[j].charAt(i)) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
        }

        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String result = lcp.longestCommonPrefix(args);
        System.out.println("result: *" + result + "*");
    }
}
