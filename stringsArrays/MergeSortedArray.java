/**
 * Merge sorted array (174):
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
 */

/*
 * time: O(m + n)
 * space: O(1)
 */

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, idx = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[idx] = nums1[i];
                --i;
            } else {
                nums1[idx] = nums2[j];
                --j;
            }
            --idx;
        }

        while (j >= 0) {
            nums1[idx] = nums2[j];
            --idx;
            --j;
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java <prog> <size1> <item1> <item2> ... <size2> <item1> <item2> ...");
            System.exit(1);
        }

        int idx = 0;
        int m = Integer.parseInt(args[idx++]);
        int[] nums1 = new int[m];
        for (int i = 0; i < m; ++i) {
            nums1[i] = Integer.parseInt(args[idx++]);
        }

        int n = Integer.parseInt(args[idx++]);
        int[] nums2 = new int[n];
        for (int i = 0; i < n; ++i) {
            nums2[i] = Integer.parseInt(args[idx++]);
        }

        int[] newNums1 = new int[m + n];
        for (int i = 0; i < m; ++i) {
            newNums1[i] = nums1[i];
        }

        System.out.println("nums1: " + Arrays.toString(newNums1));
        System.out.println("nums2: " + Arrays.toString(nums2));

        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(newNums1, m, nums2, n);
        System.out.println("result: " + Arrays.toString(newNums1));
    }
}
