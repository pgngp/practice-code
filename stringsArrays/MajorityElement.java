/**
 * Majority element (167):
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. (assume that the array is non-empty and the majority element always exist in the array.)
 * http://www.programcreek.com/2014/02/leetcode-majority-element-java/
 */

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = nums[0], maxCount = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);   
            } else {
                map.put(num, map.get(num) + 1);
            }

            if (maxCount < map.get(num)) {
                maxCount = map.get(num);
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
