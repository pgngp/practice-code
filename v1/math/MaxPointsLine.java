/**
 * Max points on a line (150):
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
 */

/**
 * time: O(n^3)
 * space: O(n) (used for storing the input points of a line)
 */

public class MaxPointsLine {
    public static int getMaxPointsOnLine(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("array of points is null");
        }

        if (points.length <= 2) {
            return points.length;
        }

        int maxNumPointsOnLine = 2;
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                int numPointsOnLine = 2;
                boolean isHorizontal = points[i].getY() == points[j].getY() ? true : false;
                boolean isVertical = points[i].getX() == points[j].getX() ? true : false;
                double slope = isVertical ? 
                    Double.MAX_VALUE : (points[j].getY() - points[i].getY()) / (points[j].getX() - points[i].getX());
                double yIntercept = isVertical ? Double.MAX_VALUE : points[i].getY() - (slope * points[i].getX());
                for (int k = j + 1; k < points.length; ++k) {
                    if ((isVertical && points[i].getX() == points[k].getX()) ||
                            (isHorizontal && points[i].getY() == points[k].getY()) ||
                            (points[k].getY() == ((slope * points[k].getX()) + yIntercept))) {
                        ++numPointsOnLine;
                    }
                }
                maxNumPointsOnLine = Math.max(maxNumPointsOnLine, numPointsOnLine);
            }
        }

        return maxNumPointsOnLine;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java <prog> <point> [<point>...]");
            System.exit(1);
        }

        Point[] points = new Point[args.length];
        MaxPointsLine mpl = new MaxPointsLine();
        for (int i = 0; i < args.length; ++i) {
            String[] parts = args[i].split(",");
            points[i] = mpl.new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        System.out.print("Input: ");
        for (int i = 0; i < args.length; ++i) {
            System.out.print(String.format("(%.2f,%.2f) ", points[i].getX(), points[i].getY()));
        }
        System.out.println();

        int max = getMaxPointsOnLine(points);
        System.out.println("Max points on line: " + max);
    }

    private class Point {
        private double x;
        private double y;

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
