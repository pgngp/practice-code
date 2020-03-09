/**
 * Single number (116):
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * http://www.programcreek.com/2012/12/leetcode-solution-of-single-number-in-java/
 */

/**
 * time: O(n)
 * space: O(1)
 */

public class SingleNumber {
    public static int getSingleNumber(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be empty");
        } else if (arr.length == 1) {
            return arr[0];
        }

        int num = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            num ^= arr[i];
        }

        return num;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java <prog> <item1> [<item2> ...]");
            System.exit(1);
        }

        int[] arr = new int[args.length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(args[i]);
        }

        int singleNum = getSingleNumber(arr);
        System.out.println("Single num: " + singleNum);
    }
}
