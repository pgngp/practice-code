/**
 * 3 sum (197):
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * http://www.programcreek.com/2012/12/leetcode-3sum/
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0 || (i < left - 1 && nums[left - 1] == nums[left])) {
                    ++left;
                } else if (sum > 0) {
                    --right;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    ++left;
                    --right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <size> <item1> <item2> <item3> ...");
            System.exit(1);
        }

        int size = Integer.parseInt(args[0]);
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        ThreeSum ts = new ThreeSum();
        List<List<Integer>> result = ts.threeSum(nums);
        System.out.println("result: " + result);
    }
}
