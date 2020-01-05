/**
 * Search insert position (136):
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * http://www.programcreek.com/2013/01/leetcode-search-insert-position/
 */

/*
 * time: O(log n)
 * space: O(1)
 */

import java.util.Arrays;

public class SearchInsertPos {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[mid] > target ? mid : mid + 1;
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
        System.out.println("target: " + s);
        System.out.println("nums: " + Arrays.toString(arr));

        SearchInsertPos sip = new SearchInsertPos();
        int result = sip.searchInsert(arr, s);
        System.out.println("result: " + result);
    }
}
