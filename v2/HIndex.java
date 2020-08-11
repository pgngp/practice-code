/* https://leetcode.com/problems/h-index/ */
class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;    
        }
        
        // sort
        Arrays.sort(citations);
        
        // binary search
        int n = citations.length, i = 0, j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (n - mid <= citations[mid]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        
        if (citations[i] == 0) {
            return 0;
        }
        
        return n - i;
    }
}
