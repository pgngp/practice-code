/**
 * Power (129):
 * Implement pow(x, n).
 * http://www.programcreek.com/2012/12/leetcode-powx-n/
 */

public class Power {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
            return 1.0;
        }

        boolean isNegExp = n < 0 ? true : false;
        n = Math.abs(n);
        double result = 1.0;
        while (n > 0) {
            result *= x;
            --n;
        }

        if (isNegExp) {
            result = 1.0 / result;
        }

        return result;
    }

    public static void main(String[] args) {
        Power p = new Power();
        double result = p.myPow(Double.parseDouble(args[0]), Integer.parseInt(args[1]));
        System.out.println("result: " + result);
    }
}
