/**
 * Median of 2 sorted arrays (161):
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 */

/*
 * time: O(log(min(m, n)))
 * space: O(1)
 */

import java.util.Arrays;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) {
            if (l2 % 2 == 0) {
                int mid = l2 / 2;
                return (nums2[mid - 1] + nums2[mid]) / 2.0;
            } else {
                return nums2[l2 / 2];
            }
        } else if (l2 == 0) {
            if (l1 % 2 == 0) {
                int mid = l1 / 2;
                return (nums1[mid - 1] + nums1[mid]) / 2.0;
            } else {
                return nums1[l1 / 2];
            }
        }

        if (l1 > l2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        boolean isEven = (l1 + l2) % 2 == 0;
        int start = 0;
        int end = l1 - 1;
        while (start <= end) {
            int part1 = (start + end) / 2;
            int part2 = ((l1 + l2 + 1) / 2) - part1;
            int x1 = part1 <= 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
            int x2 = part1 >= l1 ? Integer.MAX_VALUE : nums1[part1];
            int y1 = part2 <= 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
            int y2 = part2 >= l2 ? Integer.MAX_VALUE : nums2[part2];
            if (x1 <= y2 && y1 <= x2) {
                return isEven ? (Math.max(x1, y1) + Math.min(x2, y2)) / 2.0 : Math.max(x1, y1);
            } else if (x1 > y2) {
                end = part1 - 1;
                start = end < 0 ? end : start;
            } else {
                start = part1 + 1;
                end = start >= l1 ? start : end;
            }
        }

        throw new IllegalArgumentException("arrays not sorted");
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <size> <item1> ... <size> <item1> ...");
            System.exit(1);
        }

        int size1 = Integer.parseInt(args[0]);
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; ++i) {
            nums1[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println("nums1: " + Arrays.toString(nums1));

        int size2 = Integer.parseInt(args[size1 + 1]);
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(args[i + size1 + 2]);
        }
        System.out.println("nums2: " + Arrays.toString(nums2));

        Median m = new Median();
        double result = m.findMedianSortedArrays(nums1, nums2);
        System.out.println("result: " + result);
    }
}
