/* https://leetcode.com/problems/pancake-sorting/ */
class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        int n = A.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length - 1; i++) {
            int idx = getIdx(A, n);
            flip(A, idx);
            result.add(idx + 1);
            flip(A, n - 1);
            result.add(n);
            n--;
        }
        
        return result;
    }
    
    private int getIdx(int[] A, int n) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == n) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void flip(int[] A, int idx) {
        int i = 0, j = idx;
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }
}
