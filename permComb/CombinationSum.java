/**
 * Combination sum (133):
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.
 * Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak). The solution set must not contain duplicate combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is:
 * [7]
 * [2, 2, 3]
 * http://www.programcreek.com/2014/02/leetcode-combination-sum-java/
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; ++i) {
            list.add(candidates[i]);
            helper(candidates, result, list, candidates[i], candidates[i], i, target);
            list.remove(list.size() - 1);
        }

        return result;
    }

    private void helper(int[] arr, List<List<Integer>> listOfList, List<Integer> currList, int currNum, int currSum, int start, int target) {
        if (start >= arr.length) {
            return;
        } else if (start > 0 && arr[start] == arr[start - 1]) {
            helper(arr, listOfList, currList, currNum, currSum - arr[start], start + 1, target);
            return;
        } else if (currNum == target) {
            currList.add(currNum);
            listOfList.add(currList);
            return;
        } else if (currSum + arr[start] > target) {
            return;
        }

        currSum += arr[start];
        currList.add(arr[start]);
        if (currSum == target) {
            listOfList.add(new ArrayList<>(currList));
        } else if (currSum < target) {
            helper(arr, listOfList, currList, currNum, currSum, start, target);
        }
        
        currList.remove(currList.size() - 1);
        helper(arr, listOfList, currList, currNum, currSum - arr[start], start + 1, target);
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

        CombinationSum cs = new CombinationSum();
        List<List<Integer>> listOfList = cs.combinationSum(arr, target);
        System.out.println("Output: " + listOfList.size());
        for (int i = 0; i < listOfList.size(); ++i) {
            List<Integer> list = listOfList.get(i);
            System.out.printf("%s%n", list.toString());
        }
    }
}
