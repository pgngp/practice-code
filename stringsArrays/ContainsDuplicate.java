/**
 * Contains duplicate (126):
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * http://www.programcreek.com/2014/05/leetcode-contains-duplicate-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <num1> <num2> ...");
            System.exit(1);
        }

        int n = args.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        ContainsDuplicate cd = new ContainsDuplicate();
        boolean result = cd.containsDuplicate(nums);
        System.out.println("result: " + result);
    }
}
