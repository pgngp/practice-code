/**
 * Combinations (136):
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, if n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * http://www.programcreek.com/2014/03/leetcode-combinations-java/
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            throw new IllegalArgumentException("invalid value for n and/or k");
        }

        int combinations = (int) getNChooseK(n, k);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < combinations; ++i) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }

        for (int i = 0; i < k; ++i) {
            int idx = 0;
            while (idx < result.size()) {
                int start = i > 0 ? result.get(idx).get(i - 1) + 1 : 1;
                int totalCount = (int) getNChooseK(n - start + 1, k - i);
                int end = calculateEnd(start, totalCount, n, k, i);
                for (int j = start; j <= end; ++j) {
                    int count = (int) getNChooseK(n - j, k - i - 1);
                    for (int l = 0; l < count; ++l) {
                        List<Integer> list = result.get(idx);
                        list.add(j);
                        ++idx;
                    }
                }
            }
        }

        return result;
    }

    private int calculateEnd(int start, int totalCount, int n, int k, int currPos) {
        int i = 0;
        while (i < totalCount) {
            int count = (int) getNChooseK(n - start, k - currPos - 1);
            i += count;
            ++start;
        }
        --start;

        return start > n ? n : start;
    }

    private long getNChooseK(int n, int k) {
        return (long) getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
    }

    private long getFactorial(int n) {
        if (n == 0) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; ++i) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <n> <k>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        Combinations c = new Combinations();
        List<List<Integer>> result = c.combine(n, k);
        System.out.println("Output: " + result.size());
        System.out.println(result);
    }
}
