/**
 * Happy number (168):
 * Write an algorithm to determine if a number is "happy".
 * What is an happy number can be shown in the following example:
 * 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * http://www.programcreek.com/2014/04/leetcode-happy-number-java/
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappyNumber(long num) throws IllegalArgumentException {
        if (num <= 0) {
            throw new IllegalArgumentException("number needs to be positive");
        }

        if (num == 1) {
            return true;
        }

        long sum = 0;
        Set<Long> set = new HashSet<>();
        while (!set.contains(num)) {
            set.add(num);
            while (num > 0) {
                int remainder = (int) num % 10;
                sum += (remainder * remainder);
                num /= 10;
            }

            if (sum == 1) {
                return true;
            }

            num = sum;
            sum = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <arg>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        boolean isHappy = isHappyNumber(num);
        if (isHappy) {
            System.out.println(String.format("%d is a happy number", num));
        } else {
            System.out.println(String.format("%d is not a happy number", num));
        }
    }
}
