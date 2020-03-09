/**
 * Power of two (108):
 * Given an integer, write a function to determine if it is a power of two.
 * http://www.programcreek.com/2014/07/leetcode-power-of-two-java/
 */

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0; 
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <num>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        boolean isPowOf2 = isPowerOfTwo(num);
        System.out.printf("Is %d power of 2? %b%n", num, isPowOf2);
    }
}
