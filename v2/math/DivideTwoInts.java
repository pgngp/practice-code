/**
 * Divide two integers (124):
 * Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
 * http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/
 */

/*
 * time: O((log n)^2)
 * space: O(1)
 */

public class DivideTwoInts {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        boolean isNeg = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNeg = true;
        }
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long count = 0, incr = 1, orig = d;
        while (n >= orig) {
            if (n >= d + d) {
                d += d;
                incr += incr;
            } else {
                d = orig;
                incr = 1;
            }
            n -= d;
            count += incr;
        }

        if (isNeg) {
            count = -count;
        } else if (count > Integer.MAX_VALUE) {
            count = Integer.MAX_VALUE;
        }

        return (int) count;
    }

    public static void main(String[] args) {
        DivideTwoInts d = new DivideTwoInts();
        int result = d.divide(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("result: " + result);
    }
}
