/**
 * Perfect square:
 * Determine if an integer is a perfect square.
 */

/**
 * time: O(1)
 * space: O(1)
 */

public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num should be greater than or equal to 0");
        }

        double sqrt = Math.sqrt(num);
        int sqrtInt = (int) sqrt;
        if (sqrt - sqrtInt > 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <num>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        boolean perfectSquare = isPerfectSquare(num);
        if (perfectSquare) {
            System.out.println(String.format("Num %d is a perfect square", num));
        } else {
            System.out.println(String.format("Num %d is not a perfect square", num));
        }
    }
}
