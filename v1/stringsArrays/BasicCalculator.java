/**
 * Basic calculator (91):
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces.You may assume that the given expression is always valid.
 * Some examples: "1 + 1" = 2, "(1)" = 1, "(1-(4-5))" = 2
 * http://www.programcreek.com/2014/06/leetcode-basic-calculator-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst("(");
            } else if (c == ')') {
                String op1 = stack.removeFirst();
                if (stack.peekFirst().equals("(")) {
                    stack.removeFirst();
                }
                if (stack.size() == 0) {
                    stack.addFirst(op1);
                } else if (stack.peekFirst().equals("+")) {
                    stack.removeFirst();
                    String op2 = stack.removeFirst();
                    int result = Integer.parseInt(op2) + Integer.parseInt(op1);
                    stack.addFirst(Integer.toString(result));
                } else if (stack.peekFirst().equals("-")) {
                    stack.removeFirst();
                    String op2 = stack.removeFirst();
                    int result = Integer.parseInt(op2) - Integer.parseInt(op1);
                    stack.addFirst(Integer.toString(result));
                }
            } else if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    ++i;
                }
                String op1 = s.substring(start, i);
                if (stack.size() == 0 || stack.peekFirst().equals("(")) {
                    stack.addFirst(op1);
                } else {
                    String operator = stack.removeFirst();
                    String op2 = stack.removeFirst();
                    if (operator.equals("+")) {
                        int result = Integer.parseInt(op2) + Integer.parseInt(op1);
                        stack.addFirst(Integer.toString(result));
                    } else {
                        int result = Integer.parseInt(op2) - Integer.parseInt(op1);
                        stack.addFirst(Integer.toString(result));
                    }
                }
                --i;
            } else if (c == '+') {
                stack.addFirst("+");
            } else if (c == '-') {
                stack.addFirst("-");
            }
            ++i;
        }

        if (stack.size() > 1 && (stack.peekFirst().equals("+") || stack.peekFirst().equals("-"))) {
            String op1 = stack.removeFirst();
            String operator = stack.removeFirst();
            String op2 = stack.removeFirst();
            if (operator.equals("+")) {
                int result = Integer.parseInt(op2) + Integer.parseInt(op1);
                stack.addFirst(Integer.toString(result));
            } else {
                int result = Integer.parseInt(op2) - Integer.parseInt(op1);
                stack.addFirst(Integer.toString(result));
            }
        }

        return Integer.parseInt(stack.removeFirst());
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        int result = bc.calculate(args[0]);
        System.out.println("result: " + result);
    }
}
