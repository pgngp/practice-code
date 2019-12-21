/**
 * Two sum (376):
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * For example:
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
 */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                result[0] = map.get(tmp);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <target> <arr size> <item1> <item2> ...");
            System.exit(1);
        }

        int target = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }

        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(nums, target);
        System.out.println("result: " + Arrays.toString(result));
    }
}
