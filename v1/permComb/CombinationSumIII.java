/**
 * Combination sum III (109):
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
 * Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 * http://www.programcreek.com/2014/05/leetcode-combination-sum-iii-java/
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || n < 1) {
            throw new IllegalArgumentException("n and/or k are invalid");
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0, k, n, list, result);

        return result;
    }

    private void helper(int start, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (k > 1 && (n / 2) <= start) {
            return;
        } else if (start > 9 || k < 0 || n < 0) {
            return;
        } else if (n == 0 && k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start + 1; i <= 9; ++i) {
            if (k - 1 < 0 || n - i < 0) {
                return;
            }

            list.add(i);
            helper(i, k - 1, n - i, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <k> <n>");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        CombinationSumIII cs = new CombinationSumIII();
        List<List<Integer>> result = cs.combinationSum3(k, n);
        System.out.println("Output: " + result.size());
        System.out.println(result);
    }
}
