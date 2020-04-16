/**
 * Permutations (167):
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * http://www.programcreek.com/2013/02/leetcode-permutations-java/
 */

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, result, list, set);

        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, Set<Integer> set) {
        if (set.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            list.add(nums[i]);
            helper(nums, result, list, set);
            list.remove(list.size() - 1);
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("nums: " + Arrays.toString(nums));
        Permutations p = new Permutations();
        List<List<Integer>> result = p.permute(nums);
        System.out.println("result: " + result);
    }
}
