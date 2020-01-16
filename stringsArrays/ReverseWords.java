/**
 * Reverse words in a string (252):
 * Given an input string, reverse the string word by word.
 * For example, given s = "the sky is blue", return "blue is sky the".
 * http://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class ReverseWords {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public String reverseWords3(String s) {
        String[] arr = s.trim().split("\\s+");
        if (arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > 0; --i) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[0]);

        return sb.toString();
    }

    public String reverseWords2(String s) {
        if (s.length() <= 1) {
            return s.trim();
        }

        // reverse chars
        char[] arr = s.trim().toCharArray();
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }

        // reverse words
        i = 0;
        j = 0;
        while (i < n && j < n) {
            if (arr[i] == ' ') {
                ++i;
                ++j;
                continue;
            } else if (j == n - 1) {
                ++j;
            } else if (arr[j] != ' ') {
                ++j;
                continue;
            }
            int wordEnd = j;
            --j;

            while (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
                --j;
            }
            i = wordEnd + 1;
            j = i;
        }

        // remove leading spaces and combine spaces in middle
        i = 0;
        j = 0;
        while (j < n) {
            if (arr[j] == ' ' && arr[j - 1] == ' ') {
                ++j;
                continue;
            }

            arr[i] = arr[j];
            ++i;
            ++j;
        }
        if (i < j) {
            arr[i] = ' ';
            while (i >= 0 && arr[i] == ' ') {
                --i;
            }
            ++i;
        }

        return new String(arr, 0, i);
    }

    public static void main(String[] args) {
        System.out.println("input: " + args[0]);
        ReverseWords rw = new ReverseWords();
        String result = rw.reverseWords(args[0]);
        System.out.println("result: *" + result + "*");    
    }
}
 
