/**
 * Maximum binary gap (?):
 * Problem: Get maximum binary Gap.
 * For example, 9's binary form is 1001, the gap is 2.
 * http://www.programcreek.com/2013/02/twitter-codility-problem-max-binary-gap/
 */

/**
 * time: O(1)
 * space: O(1)
 */

public class MaxBinaryGap {
    public static int getMaxBinaryGap(int num) {
        if (num >= 0 && num <= 4) {
            return 0;
        }

        int i = 0;
        int count = 0;
        int max = 0;
        boolean started = false;
        while (i < 32) {
            int mask = (1 << i);
            boolean isSet = (mask & num) > 0 ? true : false;
            if (isSet && !started) {
                started = true;
                count = 0;
            } else if (isSet) {
                max = Math.max(max, count);
                count = 0;
            } else if (started) {
                ++count;
            }
            ++i;
        }

        return max;
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
