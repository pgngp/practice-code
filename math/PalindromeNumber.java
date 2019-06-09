/**
 * Palindrome number (225):
 * Determine whether an integer is a palindrome. Do this without extra space.
 * http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
 */

public class PalindromeNumber {
    /* solution 1
    public static boolean isNumberPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int origNum = num;
        int newNum = 0;

        while (num > 0) {
            newNum = (newNum * 10) + (num % 10);
            num /= 10;
        }

        return newNum == origNum;
    }*/

    /* solution 2 */
    public static boolean isNumberPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int divisor = 10;
        while ((num / divisor) > 10) {
            divisor *= 10;
        }

        while (num >= 10) {
            int leading = num / divisor;
            int trailing = num % 10;

            if (leading != trailing) {
                return false;
            }

            num = (num % divisor) / 10;
            divisor /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: Input integer not specified");
            System.exit(1);
        }

        int input = Integer.parseInt(args[0]);
        boolean isPalindrome = isNumberPalindrome(input);
        if (isPalindrome) {
            System.out.println(String.format("Given number %d is a palindrome", input));
        } else {
            System.out.println(String.format("Given number %d is not a palindrome", input));
        }
    }
}
