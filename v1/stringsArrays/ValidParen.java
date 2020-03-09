/**
 * Valid parenthesis (204):
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.Deque;
import java.util.LinkedList;

public class ValidParen {
    public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            Character c2 = stack.poll();
            if (c2 == null || (c == ')' && c2 != '(') || (c == '}' && c2 != '{') || (c == ']' && c2 != '[')) {
                return false;
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <str>");
            System.exit(1);
        }

        ValidParen vp = new ValidParen();
        boolean result = vp.isValid(args[0]);
        System.out.println("result: " + result);
    }
}
