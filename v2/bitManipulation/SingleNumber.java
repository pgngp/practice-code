/**
 * Single number (116):
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * http://www.programcreek.com/2012/12/leetcode-solution-of-single-number-in-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("nums: " + Arrays.toString(nums));

        SingleNumber sn = new SingleNumber();
        int result = sn.singleNumber(nums);
        System.out.println("result: " + result);
    }
}
