/**
 * Search for a range (158):
 * Given a sorted array of integers, find the starting and ending position of a given target value. Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1]. For example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * http://www.programcreek.com/2014/04/leetcode-search-for-a-range-java/
 */

/*
 * time: O(log n)
 * space: O(1)
 */

import java.util.*;

public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, 0, nums.length - 1, target);
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (pos == -1) {
            return result;
        }

        result[0] = pos;
        result[1] = pos;
        while (pos != -1) {
            pos = binarySearch(nums, 0, pos - 1, target);
            if (pos != -1) {
                result[0] = pos;
            }
        }

        pos = result[1];
        while (pos != -1) {
            pos = binarySearch(nums, pos + 1, nums.length - 1, target);
            if (pos != -1) {
                result[1] = pos;
            }
        }

        return result;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("target: " + target + ", nums: " + Arrays.toString(nums));
        SearchForRange sfr = new SearchForRange();
        int[] result = sfr.searchRange(nums, target);
        System.out.println("result: " + Arrays.toString(result));
    }
}
