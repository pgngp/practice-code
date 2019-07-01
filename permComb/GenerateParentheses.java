/**
 * Generate parentheses (179):
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * http://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is less than or equal to 0");
        } else if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }

        Set<String> result = null; 
        for (int i = 0; i < n; ++i) {
            Set<String> tmp = addParens(result);
            result = tmp;
        }

        return new ArrayList<String>(result);
    }

    private Set<String> addParens(Set<String> set) {
        if (set == null || set.size() == 0) {
            Set<String> result = new HashSet<>();
            result.add("()");
            return result;
        }

        Set<String> result = new HashSet<>();
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            String s = (String) iter.next();
            StringBuilder sb = new StringBuilder();
            sb.append("()").append(s);
            result.add(sb.toString());
            sb.delete(0, sb.length());

            sb.append("(").append(s).append(")");
            result.add(sb.toString());
            sb.delete(0, sb.length());

            List<String> list = split(s);
            for (int i = 0; i < list.size(); ++i) {
                for (int j = i; j < list.size(); ++j) {
                    sb.delete(0, sb.length());
                    for (int k = 0; k < list.size(); ++k) {
                        if (k == i) {
                            sb.append("(");
                        }
                        sb.append(list.get(k));
                        if (k == j) {
                            sb.append(")");
                        }
                    }
                    result.add(sb.toString());
                }
            }

            sb.delete(0, sb.length());
            sb.append(s).append("()");
            result.add(sb.toString());
        }

        return result;
    }

    private List<String> split(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append("(");
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                sb.append(")");
                --count;
            } else {
                sb.append("(");
                ++count;
            }

            if (count == 0) {
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        return list;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <n>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        GenerateParentheses gp = new GenerateParentheses();
        List<String> result = gp.generateParenthesis(n);
        System.out.println("n: " + result.size());
        for (int i = 0; i < result.size(); ++i) {
            System.out.println(result.get(i));
        }
    }
}

