/**
 * Insert interval (136):
 * Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * http://www.programcreek.com/2012/12/leetcode-insert-interval/
 */

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/*
 * time: O(n)
 * space: O(1)
 */

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        double pos0 = bsearch(intervals, newInterval[0]);
        double pos1 = bsearch(intervals, newInterval[1]);

        int[][] newIntervals = null;
        if (pos0 == pos1) {
            if (pos0 >= 0 && pos0 <= n - 1) {
                if (pos0 == Math.floor(pos0)) {
                    return intervals;
                }

                newIntervals = new int[n + 1][2];
                int idx = 0;
                for (int i = 0; i < n; ++i) {
                    if (i == (int) Math.ceil(pos0)) {
                        newIntervals[idx++] = newInterval;
                    }
                    newIntervals[idx++] = intervals[i];
                }
            } else {
                newIntervals = new int[n + 1][2];
                int idx = 0;
                if (pos0 < 0) {
                    newIntervals[idx++] = newInterval;
                } else if (pos0 > n - 1) {
                    newIntervals[n] = newInterval;
                }

                for (int i = 0; i < n; ++i) {
                    newIntervals[idx++] = intervals[i];
                }
            }
        } else {
            pos0 = Math.ceil(pos0);
            pos1 = Math.floor(pos1);
            newIntervals = new int[n - ((int) pos1 - (int) pos0)][2];
            newInterval[0] = Integer.min(newInterval[0], intervals[(int) pos0][0]);
            newInterval[1] = Integer.max(newInterval[1], intervals[(int) pos1][1]);
            int idx = 0;
            boolean isAdded = false;
            for (int i = 0; i < n; ++i) {
                if (i >= (int) pos0 && i <= (int) pos1) {
                    if (!isAdded) {
                        isAdded = true;
                        newIntervals[idx++] = newInterval;
                    }
                    continue;
                }
                newIntervals[idx++] = intervals[i];
            }
        }

        return newIntervals;
    }

    private double bsearch(int[][] intervals, int num) {
        int start = 0;
        int end = intervals.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            int[] interval = intervals[mid];
            if (num >= interval[0] && num <= interval[1]) {
                return (double) mid;    
            } else if (num < interval[0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (mid < 0) {
            return 0.5;
        } else if (num < intervals[mid][0]) {
            return (double) mid - 0.5;
        }

        return (double) mid + 0.5;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        // find position to insert
        int pos1 = binarySearch(intervals, newInterval[0]);
        if (pos1 < 0 || pos1 >= intervals.length) {
            // do nothing
        } else if (newInterval[0] < intervals[pos1][0]) {
            if (pos1 == 0) {
                pos1 = -1;
            } else {
                //intervals[pos1][0] = newInterval[0];
            }
        } else if (newInterval[0] > intervals[pos1][1]) {
            if (pos1 == intervals.length - 1) {
                ++pos1;
            } else {
                ++pos1;
                //intervals[pos1][0] = newInterval[0]; 
            }
        }

        int pos2 = binarySearch(intervals, newInterval[1]);
        if (pos2 < 0 || pos2 >= intervals.length) {
            // do nothing
        } else if (newInterval[1] < intervals[pos2][0]) {
            if (pos2 == 0) {
                pos2 = -1;
            } else {
                --pos2;
                intervals[pos2][1] = newInterval[1];
            }   
        } else if (newInterval[1] > intervals[pos2][1]) {
            if (pos2 == intervals.length - 1) {
                ++pos2;
            } else {
                intervals[pos2][1] = newInterval[1];
            }
        }

        if (pos1 < 0 && pos2 >= 0) {
            ++pos1;
            intervals[pos1][0] = newInterval[0];
        }
        if (pos2 >= intervals.length && pos1 >= 0 && pos1 < pos2) {
            --pos2;
            intervals[pos2][1] = newInterval[1];
        }

        System.out.println("pos1: " + pos1);
        System.out.println("pos2: " + pos2);

        int[][] newIntervals = null;
        if (pos1 < 0 && pos2 < 0) {
            newIntervals = new int[intervals.length + 1][2];
            newIntervals[0] = newInterval;
            for (int i = 0; i < intervals.length; ++i) {
                newIntervals[i + 1] = intervals[i];
            }
        } else if (pos1 >= intervals.length && pos2 >= intervals.length) {
            newIntervals = new int[intervals.length + 1][2];
            for (int i = 0; i < intervals.length; ++i) {
                newIntervals[i] = intervals[i];
            }
            newIntervals[intervals.length] = newInterval;
        } else if (pos1 == pos2 && newInterval[0] < intervals[pos1][0] && newInterval[1] < intervals[pos1][0]) {
            newIntervals = new int[intervals.length + 1][];
            int idx = 0;
            for (int i = 0; i < intervals.length; ++i) {
                if (i == pos1) {
                    newIntervals[idx] = newInterval;
                    ++idx;
                }
                newIntervals[idx] = intervals[i];
                ++idx;
            }
        } else {
            intervals[pos1][0] = Integer.max(newInterval[0], intervals[pos1][0]);
            intervals[pos1][1] = Integer.max(newInterval[1], intervals[pos2][1]);
            int newIntervalLen = intervals.length - (pos2 - pos1);
            newIntervals = new int[newIntervalLen][2];
            int idx = 0;
            for (int i = 0; i < intervals.length; ++i) {
                if (i > pos1 && i <= pos2) {
                    continue;
                }
                newIntervals[idx] = intervals[i];
                ++idx;
            }
        }

        return newIntervals;
    }

    private int binarySearch(int[][] intervals, int x) {
        int start = 0;
        int end = intervals.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            int[] pair = intervals[mid];
            if (x >= pair[0] && x <= pair[1]) {
                break;
            } else if (x > pair[1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return mid;
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
            System.out.println("Usage: java <prog> <num intervals> <interval1 item1> <interval1 item2> <> <interval2 item1> <iterval2 item2> ... <new interval item1> <new interval item2>");
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

        int[] newInterval = new int[2];
        newInterval[0] = Integer.parseInt(args[size * 2 + 1]);
        newInterval[1] = Integer.parseInt(args[size * 2 + 2]);
        System.out.println("new interval:");
        System.out.println(Arrays.toString(newInterval));

        InsertInterval ii = new InsertInterval();
        int[][] result = ii.insert(intervals, newInterval);
        System.out.println("output: ");
        printMatrix(result);
    }
}
