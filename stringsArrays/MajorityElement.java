/**
 * Majority element (167):
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. (assume that the array is non-empty and the majority element always exist in the array.)
 * http://www.programcreek.com/2014/02/leetcode-majority-element-java/
 */

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = nums[0], maxCount = 1;
        for (int num : nums) {
            int tmp = map.getOrDefault(num, 0) + 1;
            map.put(num, tmp);
            if (maxCount < tmp) {
                maxCount = tmp;
                maxNum = num;
            }
        }

        return maxNum;
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
