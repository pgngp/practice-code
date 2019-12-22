/**
 * 3 sum closest (74):
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
 */

/*
 * time: O(n^2)
 * space: O(1)
 */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if (min > diff) {
                    min = diff;
                    closestSum = sum;
                }
                if (sum > target) {
                    --right;
                } else if (sum < target) {
                    ++left;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <target> <size> <item1> <item2> <item3> ...");
            System.exit(1);
        }

        int target = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }
        System.out.println("input: " + Arrays.toString(nums));
        System.out.println("target: " + target);

        ThreeSumClosest tsc = new ThreeSumClosest();
        int result = tsc.threeSumClosest(nums, target);
        System.out.println("result: " + result);
    }
}
