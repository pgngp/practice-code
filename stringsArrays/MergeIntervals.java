/**
 * Merge intervals (138):
 * Given a collection of intervals, merge all overlapping intervals. For example:
 * Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 */

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // sort the intervals
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        // merge the intervals
        int[] curr = intervals[0];
        List<int[]> result = new ArrayList<>();
        result.add(curr);
        for (int i = 1; i < intervals.length; ++i) {
            if (curr[1] < intervals[i][0]) {
                curr = intervals[i];
                result.add(curr);
            } else {
                curr[1] = Integer.max(curr[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        // create linked list
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            List<Integer> sl = new ArrayList<>();
            sl.add(intervals[i][0]);
            sl.add(intervals[i][1]);
            list.add(sl);
        }

        // sort
        List<List<Integer>> resultList = sort(list);

        // merge
        resultList = merge(resultList);
        
        // convert to array
        int[][] resultArr = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); ++i) {
            resultArr[i][0] = resultList.get(i).get(0);
            resultArr[i][1] = resultList.get(i).get(1);
        }
        
        return resultArr;
    }

    // sort
    private List<List<Integer>> sort(List<List<Integer>> list) {
        if (list.size() == 1) {
            return list;
        }

        int mid = (list.size() - 1) / 2;
        List<List<Integer>> sl1 = sort(list.subList(0, mid + 1));
        List<List<Integer>> sl2 = sort(list.subList(mid + 1, list.size()));

        List<List<Integer>> newList = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < sl1.size() && i2 < sl2.size()) {
            if (sl1.get(i1).get(0) <= sl2.get(i2).get(0)) {
                newList.add(sl1.get(i1));
                ++i1;
            } else {
                newList.add(sl2.get(i2));
                ++i2;
            }
        }

        while (i1 < sl1.size()) {
            newList.add(sl1.get(i1));
            ++i1;
        }

        while (i2 < sl2.size()) {
            newList.add(sl2.get(i2));
            ++i2;
        }
        
        return newList;
    }

    // sort
    private List<List<Integer>> merge(List<List<Integer>> list) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = list.get(0);
        result.add(curr);
        for (int i = 1; i < list.size(); ++i) {
            if (curr.get(1) < list.get(i).get(0)) {
                curr = list.get(i);
                result.add(curr);
            } else {
                curr.set(1, Integer.max(curr.get(1), list.get(i).get(1)));
            }
        }

        return result;
    }

    private static void printMatrix(int[][] t) {
        System.out.println("[");
        for (int row = 0; row < t.length; ++row) {
            System.out.print("  [ ");
            for (int col = 0; col < t[0].length; ++col) {
                System.out.print(t[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <num intervals> <interval1 item1> <interval1 item2> <> <interval2 item1> <iterval2 item2> ...");
            System.exit(1);
        }

        int size = Integer.parseInt(args[0]);
        int[][] intervals = new int[size][2];
        for (int i = 0; i < size; ++i) {
            intervals[i][0] = Integer.parseInt(args[2 * i + 1]);
            intervals[i][1] = Integer.parseInt(args[2 * i + 2]);
        }
        System.out.println("input: ");
        printMatrix(intervals);

        MergeIntervals mi = new MergeIntervals();
        int[][] result = mi.merge(intervals);
        System.out.println("output: ");
        printMatrix(result);
    }
}
