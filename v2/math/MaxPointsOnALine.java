/**
 * Max points on a line (150):
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
 */

import java.util.*;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }

        // look at each pair
        int max = 1;
        Map<Double, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; ++i) {
            int count = 1, duplicates = 0;
            System.out.println("[" + points[i][0] + "," + points[i][1] + "]");
            for (int j = i + 1; j < points.length; ++j) {
                // check if duplicate
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    ++duplicates;
                    continue;
                }

                // slope
                double slope = ((double) (points[j][0] - points[i][0])) / (points[j][1] - points[i][1]);
                if (slope == -0.0) {
                    slope = 0.0;
                } else if (slope == Double.NEGATIVE_INFINITY) {
                    slope = Double.POSITIVE_INFINITY;
                }
                System.out.println("  [" + points[j][0] + "," + points[j][1] + "]: " + slope);
                
                // put in map
                Set<Integer> set = null;
                if (map.containsKey(slope)) {
                    set = map.get(slope);
                } else {
                    set = new HashSet<>();
                    map.put(slope, set);
                }
                set.add(i);
                set.add(j);
                count = Math.max(count, set.size());
            }
            map.clear();
            max = Math.max(max, count + duplicates);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] points = new int[args.length][2];
        for (int i = 0; i < args.length; ++i) {
            String[] items = args[i].split(",");
            points[i][0] = Integer.parseInt(items[0]);
            points[i][1] = Integer.parseInt(items[1]);
        }

        MaxPointsOnALine m = new MaxPointsOnALine();
        int result = m.maxPoints(points);
        System.out.println("result: " + result);
    }
}
