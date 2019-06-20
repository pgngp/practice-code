/**
 * Reverse bits (194):
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * http://www.programcreek.com/2014/03/leetcode-reverse-bits-java/
 */

public class ReverseBits {
    public static int reverseBits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num is negative");
        }

        int lastIndex = 31;
        for (int i = 0; i < 16; ++i) {
            boolean rightBitSet = (num & (1 << i)) > 0 ? true : false;
            boolean leftBitSet = (num & (1 << (lastIndex - i))) > 0 ? true : false;
            
            int mask = 1 << (lastIndex - i);
            if (rightBitSet) {
                num |= mask;
            } else {
                mask = ~mask;
                num &= mask;
            }

            mask = 1 << i;
            if (leftBitSet) {
                num |= mask;
            } else {
                mask = ~mask;
                num &= mask;
            }
        }

        return num;
    }

    public static int reverseBitsOptimized(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num is negative");
        }

        int lastIndex = 31;
        for (int i = 0; i < 16; ++i) {
            int rightBit = (num & (1 << i));
            int leftBit = (num & (1 << (lastIndex - i)));

            if ((rightBit ^ leftBit) == 0) {
                continue;
            }

            num ^= (1 << i) | (1 << (lastIndex - i));
        }

        return num;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <num>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        //int reverse = reverseBits(num);
        int reverse = reverseBitsOptimized(num);
        System.out.println(String.format("Reverse of %d is %d", num, reverse));
    }
} 
