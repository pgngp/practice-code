/**
 * Combination sum II (92):
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.
 * Note:
 * 1) All numbers (including target) will be positive integers.
 * 2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * 3) The solution set must not contain duplicate combinations.
 * http://www.programcreek.com/2014/04/leetcode-combination-sum-ii-java/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 1) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, result, list, 0, 0, target);

        return result;
    }

    private void helper(int[] arr, List<List<Integer>> result, List<Integer> list, int start, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }

        int prev = -1;
        for (int i = start; i < arr.length; ++i) {
            if (prev == arr[i]) {
                continue;
            }

            sum += arr[i];
            list.add(arr[i]);
            helper(arr, result, list, i + 1, sum, target);
            list.remove(list.size() - 1);
            sum -= arr[i];
            prev = arr[i];
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java <prog> <target> <candidate1> [<candidate2>...]");
            System.exit(1);
        }

        int target = Integer.parseInt(args[0]);
        int[] arr = new int[args.length - 1];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(args[i + 1]);
        }

        System.out.println("Input:");
        System.out.println("    target: " + target);
        System.out.println("    candidates: " + Arrays.toString(arr));

        CombinationSumII cs = new CombinationSumII();
        List<List<Integer>> listOfList = cs.combinationSum2(arr, target);
        System.out.println("Output: " + listOfList.size());
        for (int i = 0; i < listOfList.size(); ++i) {
            List<Integer> list = listOfList.get(i);
            System.out.printf("%s%n", list.toString());
        }
    }
}
