/**
 * Remove duplicates from sorted array II (117):
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, and A is now [1,1,2,2,3].
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int i = 0, j = 1, numDupes = 0;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                nums[++i] = nums[j];
                numDupes = 0;
            } else if (numDupes == 0) {
                nums[++i] = nums[j];
                ++numDupes;
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
        RemoveDuplicatesII rd = new RemoveDuplicatesII();
        int result = rd.removeDuplicates(nums);
        System.out.println("result: " + result + ", nums: " + Arrays.toString(nums));
    }
}
