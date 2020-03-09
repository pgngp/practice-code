/**
 * Permutations (167):
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * http://www.programcreek.com/2013/02/leetcode-permutations-java/
 */

/**
 * time: O(n3*n!)
 * space: O(n*n!)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> getPermutations(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("input array is null or empty");
        } else if (arr.length == 1) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> nestedList = new ArrayList<>();
            nestedList.add(arr[0]);
            list.add(nestedList);
            return list;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; ++i) {
            list.add(arr[i]);
        }
        List<List<Integer>> set = new ArrayList<>();
        set.add(list);

        return divide(arr[0], set);
    }

    private static List<List<Integer>> divide(int num, List<List<Integer>> list) {
        if (list.size() == 1 && list.get(0).size() > 1) {
            List<Integer> nestedList = list.get(0);
            int firstNum = nestedList.get(0);
            nestedList.remove(0);
            list = divide(firstNum, list);
        }

        return merge(num, list);
    }

    private static List<List<Integer>> merge(int num, List<List<Integer>> set) {
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < set.size(); ++k) {
            List<Integer> list = set.get(k);
            for (int i = 0; i < list.size(); ++i) {
                List<Integer> newList = new ArrayList<>();
                for (int j = 0; j < list.size(); ++j) {
                    if (j == i) {
                        newList.add(num);
                    }
                    newList.add(list.get(j));
                }
                result.add(newList);
            }
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < list.size(); ++j) {
                newList.add(list.get(j));
            }
            newList.add(num);
            result.add(newList);
        }

        return result;
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

        List<List<Integer>> set = getPermutations(arr);
        for (int i = 0; i < set.size(); ++i) {
            List<Integer> nestedList = set.get(i);
            System.out.println((i + 1) + ": " + nestedList.toString());      
        }
    }
}
