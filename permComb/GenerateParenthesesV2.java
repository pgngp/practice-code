/**
 * Generate parentheses (179):
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * http://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/
 */

/**
 * space: O(n)
 */

import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesesV2 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is less than or equal to 0");
        } else if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }

        List<String> result = new ArrayList<>();
        generate(result, "", n, n);

        return result;
    }

    private void generate(List<String> result, String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
        } else if (left == 0) {
            generate(result, s + ")", left, right - 1);
        } else if (left == right) {
            generate(result, s + "(", left - 1, right);
        } else {
            generate(result, s + "(", left - 1, right);
            generate(result, s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <n>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        GenerateParenthesesV2 gp = new GenerateParenthesesV2();
        List<String> result = gp.generateParenthesis(n);
        System.out.println("n: " + result.size());
        for (int i = 0; i < result.size(); ++i) {
            System.out.println(result.get(i));
        }
    }
}

