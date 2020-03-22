/**
 * Subsets (159):
 * Given a set of distinct integers, S, return all possible subsets.
 * Note: 1) Elements in a subset must be in non-descending order. 2) The solution set must not contain duplicate subsets.
 * For example, given S = [1,2,3], the method returns:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 * http://www.programcreek.com/2013/01/leetcode-subsets-java/
 */

/*
 * time: O((2^n) * n)
 * space: O(1), not accounting for the space required for return data
 */

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int total = (int) Math.pow(2, nums.length);
        for (int i = 0; i < total; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Subsets s = new Subsets();
        List<List<Integer>> result = s.subsets(nums);
        System.out.println("result: " + result);
    }
}
