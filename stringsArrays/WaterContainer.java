/**
 * Container with most water (57):
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * http://www.programcreek.com/2014/03/leetcode-container-with-most-water-java/
 */

import java.util.*;

public class WaterContainer {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[args.length];
        for (int i = 0; i < height.length; ++i) {
            height[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(height));
        WaterContainer wc = new WaterContainer();
        int result = wc.maxArea(height);
        System.out.println("result: " + result);
    }
}
