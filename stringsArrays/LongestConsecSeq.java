/**
 * Longest consecutive sequence (122):
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
 * Your algorithm should run in O(n) complexity.
 * http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
 */

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class LongestConsecSeq {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            set.add(nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (!set.contains(num)) {
                continue;
            }
            
            set.remove(num);
            while (set.contains(--num)) {
                set.remove(num);
            }
            int count = nums[i] - num;

            num = nums[i];
            while (set.contains(++num)) {
                set.remove(num);
            }
            count += num - nums[i] - 1;
            max = Math.max(max, count);
        }

        return max;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }

        int longest = 1, count = 1;
        for (int i = min + 1; i <= max + 1; ++i) {
            if (!set.contains(i)) {
                longest = Math.max(longest, count);
                count = 0;
            } else {
                ++count;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <size> <item1> <item2> ...");
            System.exit(1);
        }

        int size = Integer.parseInt(args[0]);
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("nums: " + Arrays.toString(arr));

        LongestConsecSeq lcs = new LongestConsecSeq();
        int result = lcs.longestConsecutive(arr);
        System.out.println("result: " + result);    
    }
}
