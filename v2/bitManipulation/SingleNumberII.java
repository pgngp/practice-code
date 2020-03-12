/**
 * Single number II (102):
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * http://www.programcreek.com/2014/03/leetcode-single-number-ii-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("nums: " + Arrays.toString(nums));

        SingleNumberII sn = new SingleNumberII();
        int result = sn.singleNumber(nums);
        System.out.println("result: " + result);    
    }
}
