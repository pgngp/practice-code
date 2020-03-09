/**
 * Search in rotated sorted array II (51):
 * Follow up for "Search in Rotated Sorted Array": what if duplicates are allowed? Write a function to determine if a given target is in the array.
 * http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/
 */

/*
 * time: O(log n), but will be O(n) in the worst case
 * space: O(1)
 */

import java.util.*;

public class SearchRotatedSortedArrII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        boolean found = false;
        if (n == 0) {
            return found;
        }

        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                found = true;
                break;
            } else if (nums[s] == nums[e]) {
                ++s;
            } else if (nums[s] < nums[m] && nums[s] <= target && target < nums[m]) {
                e = m - 1;
            } else if (nums[m] < nums[e] && nums[m] < target && target <= nums[e]) {
                s = m + 1;
            } else if (nums[s] > nums[m] && (nums[s] <= target || target < nums[m])) {
                e = m - 1;
            } else if (nums[m] > nums[e] && (nums[m] < target || target <= nums[e])) {
                s = m + 1;
            } else {
                break;
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("target: " + target + ", nums: " + Arrays.toString(nums));
        SearchRotatedSortedArrII srsa = new SearchRotatedSortedArrII();
        boolean result = srsa.search(nums, target);
        System.out.println("result: " + result);
    }
}
