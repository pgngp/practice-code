/**
 * Find minimum in rotated sorted array II (103):
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * http://www.programcreek.com/2014/03/leetcode-find-minimum-in-rotated-sorted-array-ii-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class MinRotatedSortedArrII {
    public int findMin(int[] nums) {
        int n = nums.length, min = nums[0];
        if (n == 1 || nums[0] < nums[n - 1]) {
            return min;
        }

        int s = 0, e = n - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (s == e) {
                min = nums[s];
                break;
            } else if (m > 0 && nums[m - 1] > nums[m]) { // min is mid
                min = nums[m];
                break;
            } else if (nums[s] > nums[m]) { // min is on left
                e = m - 1;
            } else if (nums[m] > nums[e]) { // min is on right
                s = m + 1;
            } else if (nums[s] == nums[e]) {
                ++s;
            } else {
                min = nums[s];
                break;
            }
        }

        return min;
    }

    public int findMin2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int s, int e) {
        if (s > e) {
            return Integer.MAX_VALUE;
        } else if (e - s == 0 || nums[s] < nums[e]) {
            return nums[s];
        }

        int min = nums[s];
        while (s <= e) {
            int m = (s + e) / 2;
            if (m > 0 && nums[m - 1] > nums[m]) { // min is mid
                min = nums[m];
                break;
            } else if (nums[s] < nums[e]) {
                min = nums[s];
                break;
            } else if (nums[m] < nums[e] || nums[s] > nums[m]) { // min is on left
                e = m - 1;
            } else if (nums[m] > nums[e] || nums[s] < nums[m]) { // min is on right
                s = m + 1;
            } else { // min can be on either side
                min = Math.min(helper(nums, s, m - 1), helper(nums, m + 1, e));
                break;
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

        MinRotatedSortedArrII mrsa = new MinRotatedSortedArrII();
        int result = mrsa.findMin(nums);
        System.out.println("result: " + result);
    }
}
