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

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Subsets1 {
    /**
     * time: O(n * 2^n)
     * space: O(n + 2^n)
     */
    public static Set<Set<Integer>> getSubsets(Set<Integer> set) {
        if (set.size() == 0) {
            Set<Integer> newSet = new LinkedHashSet<>();
            Set<Set<Integer>> newSubset = new HashSet<>();
            newSubset.add(newSet);
            return newSubset;
        }

        Iterator<Integer> iter = set.iterator();
        int item = iter.next();
        set.remove(item);
        return pair(item, getSubsets(set));
    }

    /**
     * time: O(2^n)
     * space: O(n + 2^n)
     */
    public static Set<Set<Integer>> pair(int item, Set<Set<Integer>> subsets) {
        Set<Set<Integer>> newSubsets = new HashSet<>();
        Iterator<Set<Integer>> subsetIter = subsets.iterator();
        while (subsetIter.hasNext()) {
            Set<Integer> set = subsetIter.next();
            Iterator<Integer> iter = set.iterator();
            Set<Integer> newSet = new LinkedHashSet<>();
            newSet.add(item);
            while (iter.hasNext()) {
                newSet.add(iter.next());
            }
            newSubsets.add(newSet);
        }
        subsets.addAll(newSubsets);

        return subsets;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java <prog> item1 [items]");
            System.exit(1);
        }

        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < args.length; ++i) {
            set.add(new Integer(args[i]));
        }

        Set<Set<Integer>> subsets = getSubsets(set);
        System.out.println("Subsets: (" + subsets.size() + ")");
        System.out.println(subsets);
    }
}

