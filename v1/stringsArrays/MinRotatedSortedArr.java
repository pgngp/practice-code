/**
 * Find minimum in rotated sorted array (156):
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.You may assume no duplicate exists in the array.
 * http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/
 */

/*
 * time: O(log n)
 * space: O(1)
 */

import java.util.*;

public class MinRotatedSortedArr {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }

        int s = 0, e = n - 1, min = Integer.MAX_VALUE;
        while (s <= e) {
            int m = (s + e) / 2;
            if (m > 0 && nums[m - 1] > nums[m]) { // mid is min
                min = nums[m];
                break;
            } else if (nums[m] < nums[n - 1]) { // min is on left side
                e = m - 1;
            } else { // min is on right side
                s = m + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        MinRotatedSortedArr mrsa = new MinRotatedSortedArr();
        int result = mrsa.findMin(nums);
        System.out.println("result: " + result);
    }
}
