/**
 * Largest number (154):
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. (Note: The result may be very large, so you need to return a string instead of an integer.)
 * http://www.programcreek.com/2014/02/leetcode-largest-number-java/
 */

import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] sArr = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            sArr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(sArr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (int) (Long.parseLong(s2 + s1) - Long.parseLong(s1 + s2));
            }
        });

        return sArr[0].charAt(0) == '0' ? "0" : String.join("", sArr);
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        LargestNumber ln = new LargestNumber();
        String result = ln.largestNumber(nums);
        System.out.println("result: " + result);
    }
}
