/**
 * Longest valid parentheses (128):
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * http://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
 */

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParen {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        int[] cache = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.size() > 0) {
                int currLen = 0;
                int currSeqStart = stack.pop();
                if (currSeqStart > 0) {
                    currLen = cache[currSeqStart - 1];
                }
                currLen += i - currSeqStart + 1;
                max = Math.max(max, currLen);
                cache[i] = currLen;
            }
        }

        return max;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int stackSize = 0;
        int max = 0;
        int localMax = 0;
        int lastStartPos = Integer.MAX_VALUE;
        int lastEndPos = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++stackSize;
            } else if (stackSize == 0) {
                localMax = 0;
                lastStartPos = Integer.MAX_VALUE;
                lastEndPos = Integer.MIN_VALUE;
            } else if (stackSize == 1) {
                localMax += 2;
                max = Math.max(max, localMax);
                lastStartPos = i - 2 + 1;
                lastEndPos = i;
                --stackSize;
            } else if (lastEndPos + localMax + 2 == i) {
                localMax += 2;
                max = Math.max(max, lastEndPos - lastStartPos + 1 + localMax);
                lastEndPos = i;
                --stackSize;
            } else {

            }
        }

        return max;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <str>");
            System.exit(1);
        }

        LongestValidParen lvp = new LongestValidParen();
        int result = lvp.longestValidParentheses(args[0]);
        System.out.println("result: " + result);
    }
}
