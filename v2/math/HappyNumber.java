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

/*
 * time: unknown
 * space: O(1)
 */

import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow((n % 10), 2);
                n /= 10;
            }

            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        boolean result = hn.isHappy(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
