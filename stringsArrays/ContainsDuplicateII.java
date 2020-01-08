/**
 * Contains duplicate II (124):
 * Given an array of integers and an integer k, return true if and only if there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * http://www.programcreek.com/2014/05/leetcode-contains-duplicate-ii-java/
 */

import java.util.*;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        System.out.println("k: " + k);

        int[] nums = new int[args.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        ContainsDuplicateII cd = new ContainsDuplicateII();
        boolean result = cd.containsNearbyDuplicate(nums, k);
        System.out.println("result: " + result);
    }
}

