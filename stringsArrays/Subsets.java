/**
 * Subsets:
 * Create a power set of a set. For example, if a set is (1, 2, 3), the powerset would be {(), (1), (2), (3), (1, 2), (1, 3), (2, 3), (1, 2, 3)}.
 */

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int total = (int) Math.pow(2, nums.length);
        for (int i = 0; i < total; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if ((i & (1 << j)) >= 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        Subsets s = new Subsets();
        List<List<Integer>> result = s.subsets(nums);
        System.out.println("result: " + result);
    }
}
