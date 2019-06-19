/**
 * Maximum binary gap (?):
 * Problem: Get maximum binary Gap.
 * For example, 9's binary form is 1001, the gap is 2.
 * http://www.programcreek.com/2013/02/twitter-codility-problem-max-binary-gap/
 */

/**
 * time: O(logn)
 * space: O(1)
 */

public class MaxBinaryGap2 {
    public static int getMaxBinaryGap(int num) {
        if (num >= 0 && num <= 4) {
            return 0;
        }
        
        int prev = -1;
        int curr = 0;
        int count = 0;
        while (num > 0) {
            curr = (int) log2(num & -num);
            num &= num - 1;
            if (prev != -1) {
                count = Math.max(count, curr - prev - 1);
            }
            prev = curr;
        }

        return count;
    }

    private static double log2(int x) {
        return Math.log(x) / Math.log(2);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <num>");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);
        int mbg = getMaxBinaryGap(num);
        System.out.println(String.format("Max binary gap of %d is %d", num, mbg));
    }
}
