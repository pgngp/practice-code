/**
 * Count primes (111):
 * Count the number of prime numbers less than a non-negative number, n
 * http://www.programcreek.com/2014/04/leetcode-count-primes-java/
 */

/**
 * time: O(n log log n)
 * space: O(n)
 */
public class CountPrimes {
    public static int getNumPrimes(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("num needs to be non-negative");
        }

        if (num <= 1) {
            return 0;
        }

        boolean[] arr = new boolean[num];
        int numSqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= numSqrt; ++i) {
            if (arr[i]) {
                continue;
            }

            for (int j = i * i; j < num; j += i) {
                arr[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < num; ++i) {
            if (!arr[i]) {
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <arg>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        int count = getNumPrimes(num);
        System.out.println(String.format("Num primes less than %d are %d", num, count));
    }
}
