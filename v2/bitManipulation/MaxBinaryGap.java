/**
 * Maximum binary gap (?):
 * Problem: Get maximum binary Gap.
 * For example, 9's binary form is 1001, the gap is 2.
 * http://www.programcreek.com/2013/02/twitter-codility-problem-max-binary-gap/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;

public class MaxBinaryGap {
    public int binaryGap(int N) {
        int max = 0, i = 0;
        while (i < 32 && (N & (1 << i)) == 0) {
            ++i;
        }
        if ((N & (1 << i)) == 0) {
            return 0;
        }

        ++i;
        int count = 1;
        while (i < 32) {
            if ((N & (1 << i)) == 0) {
                ++count;
            } else {
                max = Integer.max(max, count);
                count = 1;
            }
            ++i;
        }

        return max;
    }

    public static void main(String[] args) {
        MaxBinaryGap mbg = new MaxBinaryGap();
        int result = mbg.binaryGap(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
