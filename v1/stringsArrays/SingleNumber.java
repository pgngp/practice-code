/**
 * Find unique number:
 * Find from a list of numbers where each number is repeating even number of times except one. Find that number?
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum ^= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));
        
        SingleNumber sn = new SingleNumber();
        int result = sn.singleNumber(nums);
        System.out.println("result: " + result);
    }
}
