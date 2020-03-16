/**
 * Reverse integer (300):
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * http://www.programcreek.com/2012/12/leetcode-reverse-integer/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;

public class ReverseInt {
    public int reverse(int x) {
        boolean isNeg = x < 0 ? true : false;
        x = Math.abs(x);
        long result = 0;
        while (x > 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }

        if (isNeg) {
            result = -result;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result; 
    }

    public static void main(String[] args) {
        ReverseInt ri = new ReverseInt();
        int result = ri.reverse(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
