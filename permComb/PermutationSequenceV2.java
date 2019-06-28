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

public class PermutationSequenceV2 {
    public String getPermutationSequence(int n, int k) {
        if (n < 1 || n > 9 || k < 1 || k > getFactorial(n)) {
            throw new IllegalArgumentException("Invalid n or k");
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }
        
        --k;
        StringBuffer sb = new StringBuffer();
        int origN = n;
        for (int i = 0; i < origN; ++i) {
            int div = getFactorial(n) / n;
            int idx = k / div;
            sb.append(list.get(idx));
            list.remove(idx);

            k %= div;
            --n;
        }

        return sb.toString();
    }

    private int getFactorial(int n) {
        int factorial = 1;
        while (n > 0) {
            factorial *= n;
            --n;
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
        PermutationSequenceV2 permutationSequence = new PermutationSequenceV2();
        String result = permutationSequence.getPermutationSequence(n, k);
        System.out.println("Output: " + result);
    }
}
