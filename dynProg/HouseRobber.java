/**
 * House robber (32):
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Example: Input: [1,2,3,1], Output: 4
 * Example: Input: [2,7,9,3,1], Output: 12
 * http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

public class HouseRobber {
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

       return Math.max(helper(nums, cache, 0), helper(nums, cache, 1));
    }

    private int helper(int[] nums, int[] cache, int idx) {
        if (idx >= nums.length) {
            return 0;
        } else if (cache[idx] == -1) {
            cache[idx] = nums[idx] + Math.max(helper(nums, cache, idx + 2), helper(nums, cache, idx + 3));
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

        HouseRobber hr = new HouseRobber();
        int result = hr.rob(nums);
        System.out.println("result: " + result);
    }
}

