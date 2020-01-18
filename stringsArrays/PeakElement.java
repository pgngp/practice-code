/**
 * Find peak element (126):
 * A peak element is an element that is greater than its neighbors. Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞. For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * http://www.programcreek.com/2014/02/leetcode-find-peak-element/
 */

/*
 * time: O(log n)
 * space: O(1)
 */

import java.util.*;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length, peak = 0;
        if (n == 1) {
            return peak;
        } 

        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int prev = m == 0 ? Integer.MIN_VALUE : nums[m - 1];
            int next = m == n - 1 ? Integer.MIN_VALUE : nums[m + 1];
            if (prev < nums[m] && nums[m] > next) {
                peak = m;
                break;
            } else if (prev > nums[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return peak;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        PeakElement pe = new PeakElement();
        int result = pe.findPeakElement(nums);
        System.out.println("result: " + result);
    }
}
