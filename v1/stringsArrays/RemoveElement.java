/**
 * Remove element (219):
 * Given an array and a value, remove all instances of that value in place and return the new length. (Note: The order of elements can be changed. It doesn't matter what you leave beyond the new length.)
 * http://www.programcreek.com/2014/04/leetcode-remove-element-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } 

        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] == val) {
                ++j;
            } else {
                nums[i] = nums[j];
                ++i;
                ++j;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int val = Integer.parseInt(args[0]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("nums: " + Arrays.toString(nums) + ", val: " + val);

        RemoveElement re = new RemoveElement();
        int result = re.removeElement(nums, val);
        System.out.println("result: " + result + ", nums: " + Arrays.toString(nums));
    }
}
