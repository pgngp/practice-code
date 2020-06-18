class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0 || citations[citations.length - 1] == 0) {
            return 0;
        }
        
        int left = 0, right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return citations.length - left;
    }
}
