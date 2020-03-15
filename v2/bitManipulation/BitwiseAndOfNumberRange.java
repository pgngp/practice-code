/**
 * Bitwise AND of number range (99):
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive. For example, given the range [5, 7], you should return 4
 * http://www.programcreek.com/2014/04/leetcode-bitwise-and-of-numbers-range-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

public class BitwiseAndOfNumberRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int count = 0;
        while (m < n) {
            m >>>= 1;
            n >>>= 1;
            ++count;
        }

        return n << count;
    }

    public static void main(String[] args) {
        BitwiseAndOfNumberRange ba = new BitwiseAndOfNumberRange();
        int result = ba.rangeBitwiseAnd(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("result: " + result);
    }
}
