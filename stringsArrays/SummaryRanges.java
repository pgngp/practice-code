/**
 * Summary ranges (140):
 * Given a sorted integer array without duplicates, return the summary of its ranges for consecutive numbers.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * http://www.programcreek.com/2014/07/leetcode-summary-ranges-java/
 */

/**
 * time: O(n)
 * space: O(1) excluding space required for output
 */

import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = 0;
        int i = 1;
        for (; i < nums.length; ++i) {
            if (nums[i - 1] + 1 < nums[i]) {
                if (start == i - 1) {
                    result.add(String.format("%d", nums[start]));
                } else {
                    result.add(String.format("%d->%d", nums[start], nums[i - 1]));
                }
                start = i;
            }
        }
        if (start == i - 1) {
            result.add(String.format("%d", nums[start]));
        } else {
            result.add(String.format("%d->%d", nums[start], nums[i - 1]));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(nums));

        SummaryRanges sr = new SummaryRanges();
        List<String> result = sr.summaryRanges(nums);
        System.out.println("result: " + result);
    }
}
