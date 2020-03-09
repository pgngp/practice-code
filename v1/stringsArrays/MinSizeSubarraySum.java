/**
 * Minimum size subarray sum (112):
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the problem constraint.
 * http://www.programcreek.com/2014/05/leetcode-minimum-size-subarray-sum-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.Arrays;

public class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = nums[0];
        while (i < n && j < n) {
            if (j < n - 1 && sum < s) {
                ++j;
                sum += nums[j];
            } else if (sum >= s) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                ++i;
            } else {
                break;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <s> <size> <item1> <item2> ...");
            System.exit(1);
        }

        int s = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(args[i + 2]);
        }
        System.out.println("s: " + s);
        System.out.println("nums: " + Arrays.toString(arr));

        MinSizeSubarraySum msss = new MinSizeSubarraySum();
        int result = msss.minSubArrayLen(s, arr);
        System.out.println("result: " + result);
    }
}
