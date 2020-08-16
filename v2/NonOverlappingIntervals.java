/* https://leetcode.com/problems/non-overlapping-intervals/ */
class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        
        // sort by starting pos
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        int prevIdx = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prevIdx][1] > intervals[i][0]) {
                if (intervals[prevIdx][1] >= intervals[i][1]) {
                    prevIdx = i;   
                }
                count++;
            } else {
                prevIdx = i;
            }
        }
        
        return count;
    }
}
