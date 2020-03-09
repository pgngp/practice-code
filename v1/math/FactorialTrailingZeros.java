/**
 * Factorial trailing zeros (75):
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * http://www.programcreek.com/2014/04/leetcode-factorial-trailing-zeroes-java/
 */

public class FactorialTrailingZeros {
    public static int getTrailingZeros(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than equal to 0");
        }

        // Calculate the smallest x such that 5^x > n
        int x = 1;
        int pow = (int) Math.pow(5, x);
        while (pow <= n) {
            ++x;
            pow = (int) Math.pow(5, x);
        }
        
        // Calculate sum(floor(n / 5^k)) where k = 1...x-1
        int sum = 0;
        for (int i = 1; i < x; ++i) {
            sum += Math.floor(((double) n) / Math.pow(5, i));
        }

        return sum;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <arg>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int count = getTrailingZeros(n);
        System.out.println(String.format("# trailing zeros in %d! = %d", n, count));
    }
}
