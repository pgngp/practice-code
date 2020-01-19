/**
 * Majority element (167):
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. (assume that the array is non-empty and the majority element always exist in the array.)
 * http://www.programcreek.com/2014/02/leetcode-majority-element-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int curr = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                ++count;
                curr = num;
            } else if (curr == num) {
                ++count;
            } else {
                --count;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        MajorityElement me = new MajorityElement();
        int result = me.majorityElement(nums);
        System.out.println("result: " + result);
    }
}
