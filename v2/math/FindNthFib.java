/**
 * Find the nth Fibonacci number:
 * Find the nth Fibonacci number
 * https://leetcode.com/problems/fibonacci-number/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class FindNthFib {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int prevPrev = 0;
        int prev = 1;
        for (int i = 2; i <= N; ++i) {
            int tmp = prev + prevPrev;
            prevPrev = prev;
            prev = tmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        FindNthFib f = new FindNthFib();
        int result = f.fib(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
