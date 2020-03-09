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

public class PermutationSequenceV3 {
    public String getPermutationSequence(int n, int k) {
        if (n < 1 || n > 9 || k < 1 || k > getFactorial(n)) {
            throw new IllegalArgumentException("Invalid n or k");
        }

        // Initialize arr
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = i + 1;
        }

        // Create index
        int[] indices = new int[n];
        int divisor = 1;
        --k;
        for (int i = 1; i <= n; ++i) {
            indices[n - i] = (k / divisor) % i;
            divisor *= i;
        }

        // Create output
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            int index = indices[i];
            sb.append(arr[index]);
            for (int j = index; j < n - 1; ++j) {
                arr[j] = arr[j + 1];
            }
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
        PermutationSequenceV3 permutationSequence = new PermutationSequenceV3();
        String result = permutationSequence.getPermutationSequence(n, k);
        System.out.println("Output: " + result);
    }
}
