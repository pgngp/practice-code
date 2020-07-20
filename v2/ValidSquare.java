/* https://leetcode.com/problems/valid-square/ */
class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // sort points
        int[][] points = new int[][] {p1, p2, p3, p4};
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        // sides
        double side1 = getDistance(points[0], points[1]);
        double side2 = getDistance(points[1], points[3]);
        double side3 = getDistance(points[3], points[2]);
        double side4 = getDistance(points[2], points[0]);
        if (side1 == 0.0 || side1 != side2 || side2 != side3 || side3 != side4) {
            return false;
        }
        
        // diagonals
        double diag1 = getDistance(points[0], points[3]);
        double diag2 = getDistance(points[1], points[2]);
        if (diag1 != diag2) {
            return false;
        }
        
        return true;
    }
    
    // get distance between 2 points
    private double getDistance(int[] p1, int[] p2) {
        double x = Math.pow(p1[0] - p2[0], 2);
        double y = Math.pow(p1[1] - p2[1], 2);
        return Math.sqrt(x + y);
    }
}
