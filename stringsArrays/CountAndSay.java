/**
 * Count and say (192):
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, …
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
 */

/*
 * time: O(nm) where n is given and m is the average length of the string
 * space: O(m)
 */

import java.util.*;

public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            char prev = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); ++j) {
                if (s.charAt(j) != prev) {
                    sb.append(Integer.toString(count)).append(Character.toString(prev));
                    count = 1;
                    prev = s.charAt(j);
                } else {
                    ++count;
                }
            }
            sb.append(Integer.toString(count)).append(Character.toString(prev));
            s = sb.toString();
        }

        return s;
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        String result = cs.countAndSay(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
