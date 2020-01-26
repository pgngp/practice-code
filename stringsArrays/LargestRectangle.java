/**
 * Largest rectangle in histogram (62):
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
 */

import java.util.*;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0, max = heights[0];
        for (; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] > heights[i]) {
                int top = stack.removeFirst();
                int area = stack.isEmpty() ? heights[top] * i : heights[top] * (i - 1 - stack.peekFirst());
                max = Math.max(max, area);
            }
            stack.addFirst(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.removeFirst();
            int area = stack.isEmpty() ? heights[top] * i : heights[top] * (i - 1 - stack.peekFirst());
            max = Math.max(max, area);
        }

        return max;
    }

    private void printMatrix(int[][] m) {
        System.out.println("[");
        for (int i = 0; i < m.length; ++i) {
            System.out.print("  [ ");
            for (int j = 0; j < m[0].length; ++j) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
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
