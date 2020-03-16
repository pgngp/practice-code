/**
 * Palindrome number (225):
 * Determine whether an integer is a palindrome. Do this without extra space.
 * http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int divisor = 10;
        while (x / divisor >= 10) {
            divisor *= 10;
        }

        while (divisor > 0) {
            int left = x / divisor;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x %= divisor;
            x /= 10;
            divisor /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        boolean result = pn.isPalindrome(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
