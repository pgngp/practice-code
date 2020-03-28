/**
 * Count primes (111):
 * Count the number of prime numbers less than a non-negative number, n
 * http://www.programcreek.com/2014/04/leetcode-count-primes-java/
 */

/*
 * time: -
 * space: O(n)
 */

import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] arr = new boolean[n];
        int count = n - 2;
        for (int i = 2; i < Math.sqrt(n); ++i) {
            if (arr[i]) {
                continue;
            }

            for (int x = i * i; x < n; x += i) {
                if (!arr[x]) {
                    arr[x] = true;
                    --count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        int result = c.countPrimes(Integer.parseInt(args[0]));
        System.out.println("count: " + result);
    }
}
