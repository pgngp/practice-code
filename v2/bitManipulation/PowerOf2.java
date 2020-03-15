/**
 * Power of two (108):
 * Given an integer, write a function to determine if it is a power of two.
 * http://www.programcreek.com/2014/07/leetcode-power-of-two-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;

public class PowerOf2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOf2 p = new PowerOf2();
        boolean result = p.isPowerOfTwo(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
