/**
 * Permutations (167):
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * http://www.programcreek.com/2013/02/leetcode-permutations-java/
 */

/**
 * time: O(n*n!)
 * space: O(n*n!)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutationsv3 {
    public List<List<Integer>> permute(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is null or empty");
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(0, arr, result);

        return result;
    }

    private void helper(int start, int[] arr, List<List<Integer>> result) {
        if (start == arr.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; ++i) {
                list.add(arr[i]);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < arr.length; ++i) {
            swap(arr, i, start);
            helper(start + 1, arr, result);
            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java <prog> <num1> [<num2> ...]");
            System.exit(1);
        }

        int[] arr = new int[args.length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(args[i]);
        }
        System.out.println("Input: " + Arrays.toString(arr));

        int numResults = 1;
        for (int i = arr.length; i > 0; --i) {
            numResults *= i;
        }
        System.out.println("Num results: " + numResults);

        Permutationsv3 permutations = new Permutationsv3();
        List<List<Integer>> set = permutations.permute(arr);
        for (int i = 0; i < set.size(); ++i) {
            List<Integer> nestedList = set.get(i);
            System.out.println((i + 1) + ": " + nestedList.toString());
        }
    }
}
