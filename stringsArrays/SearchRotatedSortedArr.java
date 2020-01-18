/**
 * Search in rotated sorted array (109):
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.
 * http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/
 */

import java.util.*;

public class SearchRotatedSortedArr {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int idx = -1;
        if (n == 0) {
            return idx;
        }

        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                idx = m;
                break;
            } else if (nums[s] > nums[m] && (target >= nums[s] || target < nums[m])) {
                e = m - 1;
            } else if (nums[m] > nums[e] && (target > nums[m] || target <= nums[e])) {
                s = m + 1;
            } else if (nums[s] <= target && target < nums[m]) {
                e = m - 1;
            } else if (nums[m] < target && target <= nums[e]) {
                s = m + 1;
            } else {
                break;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("target: " + target + ", nums: " + Arrays.toString(nums));
        SearchRotatedSortedArr srsa = new SearchRotatedSortedArr();
        int result = srsa.search(nums, target);
        System.out.println("result: " + result);
    }
}
