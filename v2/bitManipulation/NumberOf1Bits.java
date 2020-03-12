/**
 * Number of 1 bits (192):
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * http://www.programcreek.com/2014/03/leetcode-number-of-1-bits-java/
 */

import java.util.*;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits nb = new NumberOf1Bits();
        int result = nb.hammingWeight(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
