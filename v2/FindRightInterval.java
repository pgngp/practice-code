/* https://leetcode.com/problems/find-right-interval/ */
class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0];
        }
        
        // create map
        int n = intervals.length;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(new Pair<>(intervals[i][0], intervals[i][1]), i);
        }
        
        // sort
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // search for next interval
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            result[map.get(new Pair<>(intervals[i][0], intervals[i][1]))] = helper(intervals, i, map);
        }
        result[map.get(new Pair<>(intervals[n - 1][0], intervals[n - 1][1]))] = -1;
        
        return result;
    }
    
    private int helper(int[][] intervals, int targetIdx, Map<Pair<Integer, Integer>, Integer> map) {
        int start = targetIdx + 1, end = intervals.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (intervals[mid][0] >= intervals[targetIdx][1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return intervals[targetIdx][1] <= intervals[start][0] ? map.get(new Pair<>(intervals[start][0], intervals[start][1])) : -1;
    }
}
