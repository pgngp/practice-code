/** 
 * Divide two integers (124):
 * Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
 * http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/
 */

/**
 * time: O(numerator); more specifically, O(numerator / denominator)
 * space: O(1)
 */
public class DivideIntegers {
    public static int divide(int num1, int num2) throws IllegalArgumentException {
        if (num2 == 0) {
            throw new IllegalArgumentException("numerator cannot be 0");
        }

        boolean isNegative = false;
        if (num1 < 0) {
            isNegative = true;
            num1 = Math.abs(num1);
        }

        if (num2 < 0) {
            isNegative = (isNegative) ? true : false;
            num2 = Math.abs(num2);
        }

        int count = 0;
        while (num1 >= num2) {
            num1 -= num2;
            ++count;
        }

        return isNegative ? -count : count;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <int1> <int2>");
            System.exit(1);
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int quotient = divide(num1, num2);
        System.out.println(String.format("%d / %d = %d", num1, num2, quotient));
    }
}
