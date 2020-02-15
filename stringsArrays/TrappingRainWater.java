/**
 * Trapping rain water (109):
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (height[i] > height[i + 1]) {
                stack.addFirst(i);
            } else if (height[i] < height[i + 1]) {
                Integer left = stack.peekFirst();
                if (left == null) {
                    continue;
                }
                sum += Math.min(height[left], height[i + 1]) * (i - left);
                if (height[left] <= height[i + 1]) {
                    stack.removeFirst();
                }
                //stack.addFirst(i + 1);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[args.length];
        for (int i = 0; i < height.length; ++i) {
            height[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(height));

        TrappingRainWater trw = new TrappingRainWater();
        int result = trw.trap(height);
        System.out.println("result: " + result);
    }
}
