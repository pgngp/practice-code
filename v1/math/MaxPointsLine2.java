/**
 * Max points on a line (150):
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
 */

/**
 * time: O(n^2)
 * space: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsLine2 {
    public static int getMaxPointsOnLine(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("array of points is null");
        }

        if (points.length <= 2) {
            return points.length;
        }

        int max = Integer.MIN_VALUE;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            Point pointA = points[i];
            int numPointsOnLine = Integer.MIN_VALUE;
            int duplicates = 1;
            int verticals = 0;
            System.out.println(String.format("(%.2f,%.2f)", pointA.getX(), pointA.getY()));
            for (int j = i + 1; j < points.length; ++j) {
                Point pointB = points[j];
                System.out.print(String.format("  (%.2f,%.2f): ", pointB.getX(), pointB.getY()));

                // Duplicate point
                if (pointB.getX() == pointA.getX() && pointB.getY() == pointA.getY()) {
                    ++duplicates;
                    System.out.println("duplicate");
                // Vertical line
                } else if (pointB.getX() == pointA.getX()) {
                    ++verticals;
                    System.out.println("vertical");
                // Regular line
                } else {
                    double slope = (pointB.getY() - pointA.getY()) / (pointB.getX() - pointA.getX());
                    System.out.println(String.format("slope=%.2f", slope));
                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                }


            }
            
            max = Math.max(max, verticals + duplicates);    
            for (int count : map.values()) {
                max = Math.max(max, count + duplicates);
            }
            map.clear();
        }

        return max;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java <prog> <x,y> [<x,y> ...]");
            System.exit(1);
        }

        MaxPointsLine2 mpl = new MaxPointsLine2();
        Point[] points = new Point[args.length];
        for (int i = 0; i < args.length; ++i) {
            String[] parts = args[i].split(",");
            points[i] = mpl.new Point(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
        }

        System.out.print("Input: ");
        for (int i = 0; i < points.length; ++i) {
            System.out.print(String.format("(%.2f,%.2f) ", points[i].getX(), points[i].getY()));
        }
        System.out.println("");

        int max = getMaxPointsOnLine(points);
        System.out.println("Max points on a line: " + max);
    }

    private class Point {
        double x;
        double y;

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        private double getX() {
            return this.x;
        }

        private double getY() {
            return this.y;
        }
    }
}
