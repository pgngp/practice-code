/**
 * Factorial trailing zeros (75):
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * http://www.programcreek.com/2014/04/leetcode-factorial-trailing-zeroes-java/
 */

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int count = 0, product = 5;
        while (product <= n) {
            count += (n / product);
            product *= 5;
        }

        return count;
    }

    private long getSuffix(long n) {
        String result = "";
        while (n % 10 == 0) {
            n /= 10;
            result = "0" + result;
        }
        result = Long.toString(n % 10) + result;

        return Long.parseLong(result);
    }

    public static void main(String[] args) {
        FactorialTrailingZeros f = new FactorialTrailingZeros();
        int result = f.trailingZeroes(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
