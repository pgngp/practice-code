/**
 * Contains duplicate III (72):
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 */

import java.util.*;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || t < 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (k < i) {
                set.remove(nums[i - k - 1]);
            }

            int num = nums[i];
            if (!set.add(num)) {
                return true;
            }

            Integer lower = set.lower(num);
            if (lower != null && (long) num - lower <= (long) t) {
                return true;
            }

            Integer higher = set.higher(num);
            if (higher != null && higher - (long) num <= (long) t) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        int n = args.length - 2;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }
        System.out.println("k: " + k + ", t: " + t + ", nums: " + Arrays.toString(nums));

        ContainsDuplicateIII cd = new ContainsDuplicateIII();
        boolean result = cd.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("result: " + result);
    }
}
