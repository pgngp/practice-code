/**
 * Reverse words in a string (252):
 * Given an input string, reverse the string word by word.
 * For example, given s = "the sky is blue", return "blue is sky the".
 * http://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/
 */

import java.util.*;

public class ReverseWords {
    public String reverseWords(String s) {
        int n = s.length();
        if (n <= 1) {
            return s.trim();
        }

        // reverse chars
        char[] arr = s.toCharArray();
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
        while (j < n && arr[j] == ' ') {
            ++j;
        }

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
 
