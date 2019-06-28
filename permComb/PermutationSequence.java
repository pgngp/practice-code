/**
 * Permutation sequence (100):
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence. (Note: Given n will be between 1 and 9 inclusive.)
 * http://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutationSequence(int n, int k) {
        if (n < 1 || n > 9 || k < 1 || k > getFactorial(n)) {
            throw new IllegalArgumentException("Invalid n or k");
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            result.add(i);
        }

        StringBuilder sb = new StringBuilder();
        --k;
        for (int i = 0; i < result.size() - 1; ++i) {
            int factorial = getFactorial(n);
            int div = factorial / n;
            int fixedNumIdx = (k / div) + i;
            swap(result, i, fixedNumIdx);
            k %= div;
            --n;
            sb.append(result.get(i));
        }
        sb.append(result.get(result.size() - 1));

        return sb.toString();
    }

    private void swap(List<Integer> list, int i, int j) {
        int tmp1 = list.get(i);
        int tmp2 = list.get(j);
        list.set(i, tmp2);
        list.set(j, tmp1);
    }

    private int getFactorial(int n) {
        int factorial = 1;
        for (int i = 0; i < n; ++i) {
            factorial *= n - i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java <prog> <n> <k>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println("n: " + n + ", k: " + k);
        PermutationSequence permutationSequence = new PermutationSequence();
        String result = permutationSequence.getPermutationSequence(n, k);
        System.out.println("Output: " + result);
    }
}
