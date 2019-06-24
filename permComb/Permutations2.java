/**
 * Permutations II (139):
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example, [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1]
 * http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Permutations2 {
    public List<List<Integer>> permute(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is null or empty");
        }

        Set<List<Integer>> result = new HashSet<>();
        helper(0, arr, result);

        return new ArrayList<List<Integer>>(result);
    }

    private void helper(int start, int[] arr, Set<List<Integer>> result) {
        if (start == arr.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; ++i) {
                list.add(arr[i]);
            }
            result.add(list);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < arr.length; ++i) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);

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
            System.err.println("Usage: java <prog> <item1> [<item2>...]");
            System.exit(1);
        }

        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            arr[i] = Integer.parseInt(args[i]);
        }
        System.out.println("Input: " + Arrays.toString(arr));

        Permutations2 permutations = new Permutations2();
        List<List<Integer>> listOfList = permutations.permute(arr);
        for (int i = 0; i < listOfList.size(); ++i) {
            List<Integer> list = listOfList.get(i);
            System.out.println((i + 1) + ": " + list.toString());
        }
    }
}
