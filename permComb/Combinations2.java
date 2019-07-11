/**
 * Combinations (136):
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, if n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * http://www.programcreek.com/2014/03/leetcode-combinations-java/
 */

/**
 * time: O(n choose k)
 * space: O(1)
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            throw new IllegalArgumentException("Invalid n or k");
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(result, list, 1, n, k);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; ++i) {
            list.add(i);
            helper(result, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <n> <k>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        Combinations2 c = new Combinations2();
        List<List<Integer>> result = c.combine(n, k);
        System.out.println("Output: " + result.size());
        System.out.println(result);
    }
}
