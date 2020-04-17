/**
 * Permutations II (139):
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example, [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1]
 * http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
 */

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();  
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Set<List<Integer>> result = new HashSet<>();
        helper(list, result, 0);

        return new ArrayList<>(result);
    }

    private void helper(List<Integer> list, Set<List<Integer>> result, int level) {
        if (level == list.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = level; i < list.size(); ++i) {
            Collections.swap(list, i, level);
            helper(list, result, level + 1);
            Collections.swap(list, i, level);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("nums: " + Arrays.toString(nums));
        PermutationsII p = new PermutationsII();
        List<List<Integer>> result = p.permuteUnique(nums);
        System.out.println("result: " + result);
    }
}
