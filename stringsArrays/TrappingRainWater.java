/**
 * Trapping rain water (109):
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0 || n == 1) {
            return 0;
        }

        // Find local mins
        List<Integer> localMins = new ArrayList<>();
        int i = 0;
        boolean isBottom = false;
        while (i < n) {
            if (i == 0) {
                if (height[0] < height[1]) {
                    localMins.add(0);
                }
            } else if (i == n - 1) {
                if (height[n - 2] > height[n - 1]) {
                    localMins.add(i);
                }
            } else if (height[i - 1] > height[i] && height[i] < height[i + 1]) {
                localMins.add(i);
            } else if (height[i - 1] > height[i] && height[i] == height[i + 1]) {
                isBottom = true;
            } else if (isBottom && height[i] < height[i + 1]) {
                isBottom = false;
                list.add(i);
            } else if (isBottom && height[i] > height[i + 1]) {
                isBottom = false;
            }
            ++i;
        }
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
