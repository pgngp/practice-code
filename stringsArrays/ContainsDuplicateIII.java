/**
 * Contains duplicate III (72):
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 */

/*
 * time: O(nlogk)
 * space: O(k)
 */

import java.util.*;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k < 0 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        long tl = (long) t;
        for (int i = 0; i < nums.length; ++i) {
            long num = nums[i];
            if (!set.add(num)) {
                return true;
            }

            Long lower = set.lower(num);
            if (lower != null && num - lower <= tl) {
                return true;
            }

            Long higher = set.higher(num);
            if (higher != null && higher - num <= tl) {
                return true;
            }
            
            if (k <= i) {
                set.remove((long) nums[i - k]);
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
