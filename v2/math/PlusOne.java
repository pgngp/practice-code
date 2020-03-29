/**
 * Plus one (156):
 * Given a non-negative number represented as an array of digits, plus one to the number. The digits are stored such that the most significant digit is at the head of the list.
 * http://www.programcreek.com/2014/05/leetcode-plus-one-java/
 */

/*
 * time: O(n)
 * space: O(1), not counting the output array
 */

import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length, i = 0;
        while (i < n && digits[i] == 9) {
            ++i;
        }
        int newLen = (i >= n) ? n + 1 : n;

        int[] result = new int[newLen];
        int carry = 1;
        for (i = n - 1; i >= 0; --i) {
            int tmp = digits[i] + carry;
            result[i] = (tmp % 10);
            carry = (tmp >= 10) ? 1 : 0;
        }
        if (carry == 1) {
            result[0] = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] digits = new int[args.length];
        for (int i = 0; i < digits.length; ++i) {
            digits[i] = Integer.parseInt(args[i]);
        }
        PlusOne p = new PlusOne();
        int[] result = p.plusOne(digits);
        System.out.println("result: " + Arrays.toString(result));
    }
}
