/**
 * Bitwise AND of number range (99):
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive. For example, given the range [5, 7], you should return 4
 * http://www.programcreek.com/2014/04/leetcode-bitwise-and-of-numbers-range-java/
 */

public class BitwiseAnd {
    public static int bitwiseAnd(int m, int n) {
        if (m < 0 || n < 0 || m > n) {
            throw new IllegalArgumentException("m or n have invalid values");
        }

        int k = 0;
        while (m < n) {
            ++k;
            m >>= 1;
            n >>= 1;
        }

        return m << k;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <m> <n>");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int result = bitwiseAnd(m, n);
        System.out.printf("Bitwise AND of [%d, %d] = %d\n", m, n, result);
    }
} 
