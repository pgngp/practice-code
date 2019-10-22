/**
 * Evaluate reverse polish notation (142):
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; ++i) {
            String s = tokens[i];
            char c = s.charAt(0);
            if (s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                if (c == '+') {
                    stack.push(op1 + op2);
                } else if (c == '-') {
                    stack.push(op1 - op2);
                } else if (c == '*') {
                    stack.push(op1 * op2);
                } else {
                    stack.push(op1 / op2);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    private static void printTokens(String[] tokens) {
        System.out.print("tokens: [");
        for (int i = 0; i < tokens.length; ++i) {
            System.out.print(tokens[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("java <prog> <size> <item1> <item2>...");
            System.exit(1);
        }

        int size = Integer.parseInt(args[0]);
        String[] tokens = new String[size];
        for (int i = 0; i < size; ++i) {
            tokens[i] = args[i + 1];
        }
        printTokens(tokens);
        ReversePolishNotation rpn = new ReversePolishNotation();
        int result = rpn.evalRPN(tokens);
        System.out.println("result: " + result);
    }
}
