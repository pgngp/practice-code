/**
 * Majority element II (78):
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/
 */

import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                ++count1;
            } else if (num == num2) {
                ++count2;
            } else if (count1 == 0) {
                count1 = 1;
                num1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                num2 = num;
            } else {
                --count1;
                --count2;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                ++count1;
            } else if (num == num2) {
                ++count2;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        MajorityElementII me = new MajorityElementII();
        List<Integer> result = me.majorityElement(nums);
        System.out.println("result: " + result.toString());
    }
}
