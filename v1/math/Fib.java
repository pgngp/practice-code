/**
 * Find the nth Fibonacci number:
 * Find the nth Fibonacci number
 */

/**
 * time: O(n)
 * space: O(1)
 */

public class Fib {
    public static int getNthFib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than or equal to 0");
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fPrevPrev = 0;
        int fPrev = 1;
        int f = Integer.MIN_VALUE;
        for (int i = 2; i <= n; ++i) {
            f = fPrev + fPrevPrev;
            fPrevPrev = fPrev;
            fPrev = f;
        }

        return f;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <n>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int fib = getNthFib(n);
        System.out.println(String.format("Fib(%d) = %d", n, fib));
    }
}
