/**
 * Trapping rain water (109):
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int[] lmax = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            lmax[i] = max;
            max = Math.max(max, height[i]);
        }
        
        int[] rmax = new int[n];
        max = 0;
        for (int i = n - 1; i >= 0; --i) {
            rmax[i] = max;
            max = Math.max(max, height[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += Math.max(0, Math.min(lmax[i], rmax[i]) - height[i]);
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
