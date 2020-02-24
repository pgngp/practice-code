/**
 * Prime numbers (sieve of eratosthenes):
 * Print all prime numbers upto a given number
 * OR
 * Leetcode version: Count the number of prime numbers less than a non-negative number, n.
 */

/*
 * time: O(n log log n)
 * space: O(n)
 */

import java.util.*;

public class PrimeNumbers {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        int[] arr = new int[n];
        int sqrt = (int) Math.sqrt(n);
        int count = n - 2;
        for (int i = 2; i <= sqrt; ++i) {
            if (arr[i] == 1) {
                continue;
            }

            for (int multiple = 2 * i; multiple < n; multiple += i) {
                if (arr[multiple] == 0) {
                    arr[multiple] = 1;
                    --count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();
        int result = pn.countPrimes(Integer.parseInt(args[0]));
        System.out.println("result: " + result);      
    }
}
