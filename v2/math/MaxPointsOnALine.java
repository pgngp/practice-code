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

        int max = 1;
        Map<List<Double>, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; ++i) {
            System.out.println("[" + points[i][0] + "," + points[i][1] + "]");
            for (int j = i + 1; j < points.length; ++j) {
                System.out.print("  [" + points[j][0] + "," + points[j][1] + "]: ");
                double slope = ((double) (points[j][1] - points[i][1])) / (points[j][0] - points[i][0]);
                if (slope == -0.0) {
                    slope = 0.0;
                } else if (slope == Double.NEGATIVE_INFINITY) {
                    slope = Double.POSITIVE_INFINITY;
                }

                double constant = points[j][1] - (slope * points[j][0]);
                if (constant == -0.0) {
                    constant = 0.0;
                } else if (constant == Double.NEGATIVE_INFINITY) {
                    constant = Double.POSITIVE_INFINITY;
                }
                System.out.println(" (s: " + slope + ", c: " + constant + ")");
                
                List<Double> slopeConstantPair = new ArrayList<>();
                slopeConstantPair.add(slope);
                slopeConstantPair.add(constant);
                if (map.containsKey(slopeConstantPair)) {
                    Set<Integer> set = map.get(slopeConstantPair);
                    if (!set.contains(j)) {
                        set.add(j);
                    }
                    max = Math.max(max, set.size());
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    map.put(slopeConstantPair, set);
                    max = Math.max(max, set.size());
                }
            }
        }
        System.out.println("map: " + map);

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
