/**
 * Subsets II (88):
 * Given a set of integers, S, return all possible subsets. Set can contain duplicates.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
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
 * http://www.programcreek.com/2013/01/leetcode-subsets-ii-java/
 */

/*
 * time: O(nlogn + n2^n) ~= O(n2^n)
 * space: O(n2^n)
 */

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
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

        return new ArrayList<List<Integer>>(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        SubsetsII s = new SubsetsII();
        List<List<Integer>> result = s.subsetsWithDup(nums);
        System.out.println("result: " + result);
    }
}
