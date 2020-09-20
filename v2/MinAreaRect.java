/* https://leetcode.com/problems/minimum-area-rectangle/ */
class MinAreaRect {
    public int minAreaRect(int[][] points) {
        // check input
        if (points.length < 4) {
            return 0;
        }
        
        // create set
        Set<Integer> set = new HashSet<>();
        
        // add points to set
        int prime = 40001;
        for (int i = 0; i < points.length; i++) {
            set.add(prime * points[i][0] + points[i][1]);
        }
        
        // for each pair of points find if a rectangle exists
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] pointA = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if (pointA[0] != pointB[0] && pointA[1] != pointB[1]) {
                    int topLeft = prime * pointA[0] + pointB[1];
                    int bottomRight = prime * pointB[0] + pointA[1];
                    if (set.contains(topLeft) && set.contains(bottomRight)) {
                        minArea = Math.min(minArea, Math.abs(pointB[0] - pointA[0]) * Math.abs(pointB[1] - pointA[1]));
                    }    
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
