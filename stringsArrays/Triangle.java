/**
 * Triangle (141):
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * http://www.programcreek.com/2013/01/leetcode-triangle-java/
 */

import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        int[][] cache = new int[n][n];
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                cache[row][col] = Integer.MAX_VALUE;
            }
        }

        return triangle.get(0).get(0) 
            + Math.min(dfs(triangle, 1, 0, cache), dfs(triangle, 1, 1, cache));
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, int[][] cache) {
        int n = triangle.size();
        if (i >= n) {
            return 0;
        } else if (i == n - 1) {
            return triangle.get(i).get(j);
        } else if (cache[i][j] != Integer.MAX_VALUE) {
            return cache[i][j];
        }

        cache[i][j] = triangle.get(i).get(j) 
            + Math.min(dfs(triangle, i + 1, j, cache), dfs(triangle, i + 1, j + 1, cache));

        return cache[i][j];
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <item1> <item2> ...");
            System.exit(1);
        }

        List<List<Integer>> superList = new ArrayList<>();
        for (int i = 0; i < args.length; ++i) {
            List<String> input = Arrays.asList(args[i].split(","));
            List<Integer> list = new ArrayList<>();
            for (String item : input) {
                list.add(Integer.parseInt(item));
            }
            superList.add(list);
        }
        System.out.println("input: " + superList.toString());

        Triangle t = new Triangle();
        int result = t.minimumTotal(superList);
        System.out.println("result: " + result);
    }
}
