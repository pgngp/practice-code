/**
 * Isomorphic strings (158):
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            Character value = map.get(sChar);
            if (value == null && set.contains(tChar)) {
                return false;
            } else if (value == null) {
                map.put(sChar, tChar);
                set.add(tChar);
            } else if (value != tChar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <str1> <str2>");
            System.exit(1);
        }

        IsomorphicStrings is = new IsomorphicStrings();
        boolean result = is.isIsomorphic(args[0], args[1]);
        System.out.println("result: " + result);
    }
}
