/**
 * Largest rectangle in histogram (62):
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
 */

import java.util.*;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        } 

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, heights[i]);
            int currHeight = heights[i];
            int count = 1;
            for (int j = i - 1; j >= 0; --j) {
                ++count;
                currHeight = Math.min(currHeight, heights[j]);
                max = Math.max(max, currHeight * count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("nums: " + Arrays.toString(nums));
        LargestRectangle lr = new LargestRectangle();
        int result = lr.largestRectangleArea(nums);
        System.out.println("result: " + result);
    }
}
