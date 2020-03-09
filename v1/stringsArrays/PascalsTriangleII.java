/**
 * Pascal’s triangle II (152):
 * Given an index k, return the kth row of the Pascal's triangle. For example, when k = 3, the row is [1,3,3,1].
 * http://www.programcreek.com/2014/04/leetcode-pascals-triangle-ii-java/
 */

/*
 * time: O(k^2)
 * space: O(1), assuming we don't count space required for output
 */

import java.util.*;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            result.add(1);
        }

        for (int i = 2; i <= rowIndex; ++i) {
            int topLeft = 1;
            for (int j = 1; j < i; ++j) {
                int tmp = topLeft + result.get(j);
                topLeft = result.get(j);
                result.set(j, tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();
        List<Integer> result = pt.getRow(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
