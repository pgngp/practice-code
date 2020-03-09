/**
 * Subsets (159):
 * Given a set of distinct integers, S, return all possible subsets.
 * Note: 1) Elements in a subset must be in non-descending order. 2) The solution set must not contain duplicate subsets.
 * For example, given S = [1,2,3], the method returns:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * http://www.programcreek.com/2013/01/leetcode-subsets-java/
 */

/**
 * time: O(n * 2^n)
 * space: O(n * 2^n)
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets1v2 {
    public static List<List<Integer>> getSubsets(List<Integer> set) {
        List<List<Integer>> subsets = new ArrayList<>();

        if (set.size() == 0) {
            subsets.add(new ArrayList<>());
            return subsets;
        }

        int setSize = set.size();
        int totalSubsetSize = 1 << setSize;
        for (int i = 0; i < totalSubsetSize; ++i) {
            List<Integer> newSet = new ArrayList<>();
            
            for (int j = 0; j < setSize; ++j) {
                if ((i & (1 << j)) > 0) {
                    newSet.add(set.get(j));
                }
            }
            subsets.add(newSet);
        }

        return subsets;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java <prog> item1 [items...]");
            System.exit(1);
        }

        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < args.length; ++i) {
            set.add(Integer.parseInt(args[i]));
        }

        List<List<Integer>> subsets = getSubsets(set);
        System.out.println("Subsets (" + subsets.size() + "):");
        System.out.println(subsets);
    }
}

