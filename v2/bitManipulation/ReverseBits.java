/**
 * Reverse bits (194):
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * http://www.programcreek.com/2014/03/leetcode-reverse-bits-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

public class ReverseBits {
    public int reverseBits(int n) {
        int maskL = Integer.MAX_VALUE + 1, maskR = 1;
        for (int i = 0; i < 16; ++i) {
            int left = (n & maskL);
            int right = (n & maskR);
            if (left != 0 && right == 0) {
                n &= ~maskL;
                n |= maskR;
            } else if (left == 0 && right != 0) {
                n |= maskL;
                n &= ~maskR;
            }

            maskL >>>= 1;
            maskR <<= 1;
        }

        return n;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        ReverseBits rb = new ReverseBits();
        int result = rb.reverseBits(num);
        System.out.println("prev: " + Integer.toBinaryString(num) + ", now: " + Integer.toBinaryString(result));
        System.out.println("result: " + result);
    }
}
