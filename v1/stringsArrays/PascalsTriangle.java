/**
 * Pascal’s triangle (155):
 * Given numRows, generate the first numRows of Pascal's triangle. For example, given numRows = 5, the result should be:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1], 
 *  [1,4,6,4,1]
 * ]
 * http://www.programcreek.com/2014/03/leetcode-pascals-triangle-java/
 */

/*
 * time: O(n^2)
 * space: O(1), not counting the space required for the output
 */

import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> sublist = new ArrayList<>();
        sublist.add(1);
        result.add(sublist);
        if (numRows == 1) {
            return result;
        }

        List<Integer> prev = sublist;
        for (int i = 1; i < numRows; ++i) {
            sublist = new ArrayList<>();
            sublist.add(1);
            for (int j = 1; j < i; ++j) {
                sublist.add(prev.get(j - 1) + prev.get(j));
            }
            sublist.add(1);
            result.add(sublist);
            prev = sublist;
        }

        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        List<List<Integer>> result = pt.generate(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
