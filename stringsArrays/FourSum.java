/**
 * 4 sum (156):
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * http://www.programcreek.com/2013/02/leetcode-4sum-java/
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println("sorted: " + Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        int prevI = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; ++i) {
            if (prevI == nums[i]) {
                continue;
            }

            int prevJ = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (prevJ == nums[j]) {
                    continue;
                }

                int prevLeft = Integer.MAX_VALUE;
                int left = j + 1;
                int right = nums.length - 1;
                int tmpSum = nums[i] + nums[j];
                while (left < right) {
                    int sum = tmpSum + nums[left] + nums[right];
                    if (sum > target) {
                        --right;
                    } else if (sum < target || prevLeft == nums[left]) {
                        ++left;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        prevLeft = nums[left];
                        ++left;
                        --right;
                    }
                }
                prevJ = nums[j];
            }
            prevI = nums[i];
        }

        return result;
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

        FourSum fs = new FourSum();
        List<List<Integer>> result = fs.fourSum(nums, target);
        System.out.println("result: " + result);
    }
}
