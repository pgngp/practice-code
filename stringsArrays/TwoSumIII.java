/**
 * Two sum III: Data structure design (24):
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1);
 * add(3);
 * add(5);
 * find(4) -> true
 * find(7) -> false
 * http://www.programcreek.com/2014/03/two-sum-iii-data-structure-design-java/
 * (looks like this question is discontinued from leetcode)
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.Set;
import java.util.HashSet;

public class TwoSumIII {
    private Set<Integer> set;
    private int min;
    private int max;

    public TwoSumIII() {
        set = new HashSet<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void add(int num) {
        set.add(num);
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    public boolean find(int target) {
        int tmp = Math.min((target - min) / 2, max);
        for (int i = min; i <= tmp; ++i) {
            if (!set.contains(i)) {
                continue;
            }
            int diff = target - i;
            if (i != diff && set.contains(diff)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TwoSumIII ts = new TwoSumIII();
        ts.add(1);
        ts.add(3);
        ts.add(5);
        ts.add(-3);
        System.out.println("find(4): " + ts.find(4));
        System.out.println("find(7): " + ts.find(7));
        System.out.println("find(0): " + ts.find(0));
        System.out.println("find(-2): " + ts.find(-2));
    }
}
