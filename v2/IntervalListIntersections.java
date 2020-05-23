class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
            return new int[0][0];
        }
        
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int aStart = A[i][0];
            int aEnd = A[i][1];
            int bStart = B[j][0];
            int bEnd = B[j][1];
            
            if (aEnd < bStart) {
                i++;
            } else if (bEnd < aStart) {
                j++;
            } else {
                list.add(new int[]{Math.max(aStart, bStart), Math.min(aEnd, bEnd)});
                if (aEnd < bEnd) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        
        int[][] result = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
