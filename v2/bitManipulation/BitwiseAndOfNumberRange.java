/**
 * Bitwise AND of number range (99):
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive. For example, given the range [5, 7], you should return 4
 * http://www.programcreek.com/2014/04/leetcode-bitwise-and-of-numbers-range-java/
 */

public class BitwiseAndOfNumberRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int mNumBits = 0, nNumBits = 0, i = 0, pow = 1;
        while (m >= pow) {
            ++i;
            pow <<= 1;
        }
        mNumBits = m == 0 ? 0 : i - 1;

        while (n >= pow) {
            ++i;
            pow <<= 1;
        }
        nNumBits = i - 1;
        System.out.println("mNumBits: " + mNumBits + ", nNumBits: " + nNumBits);

        int mask = 0;
        if (mNumBits == nNumBits) {
            mask = ~((1 << mNumBits) - 1);
        } else {
            mask = ~((1 << (mNumBits + 1)) - 1);
        }
        int result = (m & n & mask);

        return result;
    }

    public static void main(String[] args) {
        BitwiseAndOfNumberRange ba = new BitwiseAndOfNumberRange();
        int result = ba.rangeBitwiseAnd(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("result: " + result);
    }
}
