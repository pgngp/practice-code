/**
 * Single number II (102):
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * http://www.programcreek.com/2014/03/leetcode-single-number-ii-java/
 */

/**
 * time: O(n)
 * space: O(1)
 */

public class SingleNumber2 {
    public static int getSingleNumber(int[] arr, int n) {
        if (n <= 1 || arr == null || arr.length < n + 1 || (arr.length % n) != 1) {
            throw new IllegalArgumentException("n is less than or equal to 1 or array size is not correct");
        } else if (arr.length == 1) {
            return arr[0];
        }

        int singleNum = 0;
        for (int i = 0; i < 32; ++i) {
            int mask = 1 << i;
            int count = 0;
            for (int j = 0; j < arr.length; ++j) {
                if ((arr[j] & mask) > 0) {
                    ++count;
                }
            }
            
            int modVal = count % n;
            if (modVal > 1) {
                throw new IllegalStateException(String.format("%d % %d is %d", count, n, modVal));
            }
            if (modVal == 1) {
                singleNum |= mask;
            }
        }

        return singleNum;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java <prog> <n> <item1> [<item2> ...]");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        System.out.println("n = " + n);

        int[] arr = new int[args.length - 1];
        for (int i = 1; i < args.length; ++i) {
            arr[i - 1] = Integer.parseInt(args[i]);
        }

        System.out.print("Input: ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int singleNum = getSingleNumber(arr, n);
        System.out.println("Single number: " + singleNum);
    }
}
