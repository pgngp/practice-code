/**
 * House robber II (86):
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Example: Input: [2,3,2], Output: 3
 * Example: Input: [1,2,3,1], Output: 4
 * http://www.programcreek.com/2014/05/leetcode-house-robber-ii-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            cache[i] = -1;
        }
        int sum1 = helper(nums, cache, 0, nums.length - 1);
        
        for (int i = 0; i < nums.length; ++i) {
            cache[i] = -1;
        }
        int sum2 = helper(nums, cache, 1, nums.length);
        int sum3 = helper(nums, cache, 2, nums.length);

        return Math.max(sum1, Math.max(sum2, sum3));   
    }

    private int helper(int[] nums, int[] cache, int idx, int end) {
        if (idx >= end) {
            return 0;
        } else if (cache[idx] == -1) {
            cache[idx] = nums[idx] 
                + Math.max(helper(nums, cache, idx + 2, end), helper(nums, cache, idx + 3, end));
        }

        return cache[idx];
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <n> <item1> <item2> ...");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.print("[ ");
        for (int i = 0; i < n; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        HouseRobberII hr = new HouseRobberII();
        int result = hr.rob(nums);
        System.out.println("result: " + result);
    }
}
