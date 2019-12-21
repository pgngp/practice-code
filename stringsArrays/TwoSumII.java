/**
 * Two sum II (17):
 * Similar to two sum above, but input array is sorted.
 * http://www.programcreek.com/2014/03/two-sum-ii-input-array-is-sorted-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <target> <arr size> <item1> <item2> ...");
            System.exit(1);
        }

        int target = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }

        TwoSumII ts = new TwoSumII();
        int[] result = ts.twoSum(nums, target);
        System.out.println("result: " + Arrays.toString(result));
    }
}
