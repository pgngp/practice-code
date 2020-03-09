/**
 * Power (129):
 * Implement pow(x, n).
 * http://www.programcreek.com/2012/12/leetcode-powx-n/
 */

public class Power {
    /**
     * Recursive method
     * time: O(logn)
     * space: O(1)
     */
    public static double powerRecursive(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        if (exp < 0) {
            return 1 / powerRecursive(base, -exp);
        }

        double tmp = powerRecursive(base, exp / 2);
        if (exp % 2 == 0) {
            return tmp * tmp;
        } else {
            return base * tmp * tmp;
        }
    }

    /**
     * Iterative method
     * time: O(logn)
     * space: 
     */
    public static double powerIterative(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        double result = 1;
        while (true) {
            if (exp % 2 != 0) {
                result *= base;
            }

            exp /= 2;
            if (exp == 0) {
                break;
            }

            base *= base;
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Required arguments are base and exponent");
            System.exit(1);
        }

        double base = Double.parseDouble(args[0]);
        int exponent = Integer.parseInt(args[1]);
        // double result = powerRecursive(base, exponent);
        double result = powerIterative(base, exponent);
        System.out.println(String.format("%f ^ %d: %f", base, exponent, result));
    }
}
