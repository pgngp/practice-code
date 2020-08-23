/* https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/ */
class RandomPointInNonOverlappingRectangles {
    int[] prefSum;
    Random random;
    int[][] rects;
    
    public Solution(int[][] rects) {
        // prefix sums
        prefSum = new int[rects.length];
        int prev = 0;
        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0], y1 = rects[i][1];
            int x2 = rects[i][2], y2 = rects[i][3];
            int width = x2 - x1;
            int height = y2 - y1;
            int numPoints = (width + 1) * (height + 1);
            prefSum[i] = prev + numPoints;
            prev = prefSum[i];
        }
        // System.out.println("prefSum:" + Arrays.toString(prefSum));
        
        // initialize random number
        random = new Random();
        
        this.rects = rects;
    }
    
    public int[] pick() {
        // pick rectangle
        int randNum = random.nextInt(prefSum[prefSum.length - 1]);
        // System.out.println("rn: " + randNum);
        int start = 0, end = prefSum.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (prefSum[mid] > randNum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        // pick point in rectangle
        int[] rect = rects[start];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int base = prefSum[start] - width * height;
        int pointIdx = randNum - base;
        int x = rect[0] + (pointIdx  % width);
        int y = rect[1] + (pointIdx / width);
        
        return new int[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
