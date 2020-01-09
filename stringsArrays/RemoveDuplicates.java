/**
 * Remove duplicates from sorted array (216):
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                nums[++i] = nums[j];
            }
            ++j;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));
        RemoveDuplicates rd = new RemoveDuplicates();
        int result = rd.removeDuplicates(nums);
        System.out.println("result: " + result + ", nums: " + Arrays.toString(nums));
    }
}
