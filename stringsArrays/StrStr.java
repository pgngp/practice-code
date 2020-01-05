/**
 * Implement strStr() (184):
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
 */

/*
 * time: O(m + n)
 * space: O(n)
 */

import java.util.Arrays;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (nl == 0) {
            return 0;
        } else if (hl < nl) {
            return -1;
        }
        
        int[] prefixArr = createPrefixArr(needle);
        int i = 0, j = 0;
        while (i < hl && j < nl) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = prefixArr[j - 1];
            }
        }

        return j == nl ? i - j : -1;
    }

    private int[] createPrefixArr(String needle) {
        int nl = needle.length();
        int[] arr = new int[nl];
        arr[0] = 0;
        int i = 0, j = 1;
        while (j < nl) {
            if (needle.charAt(i) == needle.charAt(j)) {
                arr[j] = i + 1;
                ++i;
                ++j;
            } else if (i == 0) {
                arr[j] = 0;
                ++j;
            } else {
                i = arr[i - 1];
            }
        }

        return arr;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int hIdx = 0;
        int nIdx = 0;
        while (hIdx < haystack.length() && nIdx < needle.length()) {
            if (haystack.charAt(hIdx) != needle.charAt(nIdx)) {
                hIdx = hIdx - nIdx + 1;
                nIdx = 0;
            } else {
                ++nIdx;
                ++hIdx;
            }
        }

        return (nIdx == needle.length()) ? hIdx - needle.length() : -1;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <haystack> <needle>");
            System.exit(1);
        }

        StrStr s = new StrStr();
        int result = s.strStr(args[0], args[1]);
        System.out.println("result: " + result);
    }
}
