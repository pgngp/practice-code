/**
 * Reverse integer (300):
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * http://www.programcreek.com/2012/12/leetcode-reverse-integer/
 */

public class ReverseInteger {
    public static int reverse(int num) {
        int reverseNum = 0;
        int multiplier = 1;

        if (num < 0) {
            multiplier = -1;
            num = Math.abs(num);
        }

        while (num != 0) {
            reverseNum = (reverseNum * 10) + (num % 10);
            num = num / 10;
        }

        return reverseNum * multiplier;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: No argument specified");
            System.exit(1);
        }

        int reverseNum = reverse(Integer.parseInt(args[0]));
        System.out.println("reverse of " + args[0] + " is: " + reverseNum);
    }
}
