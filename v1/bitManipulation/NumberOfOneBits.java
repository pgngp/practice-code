/**
 * Number of 1 bits (192):
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * http://www.programcreek.com/2014/03/leetcode-number-of-1-bits-java/
 */

/**
 * time: O(logn) where n = num
 * space: O(1)
 */

public class NumberOfOneBits {
    public static int getNumOfOneBits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) != 0) {
                ++count;
            }
            num >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <num>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        int count = getNumOfOneBits(num);
        System.out.println(String.format("Num of 1 bits in %d is %d", num, count));
    }
}
