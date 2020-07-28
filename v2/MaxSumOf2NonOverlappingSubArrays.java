/* https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/ */
class MaxSumOf2NonOverlappingSubArrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        // calculate L sums and M sums
        int n = A.length, lSum = 0, mSum = 0;
        int[] lSumArr = new int[n];
        int[] mSumArr = new int[n];
        for (int i = 0; i < n; i++) {
            lSum += A[i];
            if (i == L - 1) {
                lSumArr[i] = lSum;
            } else if (i >= L) {
                lSum -= A[i - L];
                lSumArr[i] = lSum;
            }
            
            mSum += A[i];
            if (i == M - 1) {
                mSumArr[i] = mSum;
            } else if (i >= M) {
                mSum -= A[i - M];
                mSumArr[i] = mSum;
            }
        }
        
        // keep a max-stack for M
        Deque<Integer> maxStack = new ArrayDeque<>();
        for (int i = n - 1; i >= L + M - 1; i--) {
            if (maxStack.isEmpty() || maxStack.peekFirst() <= mSumArr[i]) {
                maxStack.offerFirst(mSumArr[i]);
            }
        }
        
        // L goes left -> right and M goes left <- right
        int max = 0, maxL = 0, maxM = 0;
        for (int i = L - 1; i < n - M; i++) {
            maxL = Math.max(maxL, lSumArr[i]);
            maxM = maxStack.peekFirst();
            max = Math.max(max, maxL + maxM);
            if (mSumArr[i + M] == maxStack.peekFirst()) {
                maxStack.pollFirst();
            }
        }
        
        // keep a max-stack for L
        for (int i = n - 1; i >= L + M - 1; i--) {
            if (maxStack.isEmpty() || maxStack.peekFirst() <= lSumArr[i]) {
                maxStack.offerFirst(lSumArr[i]);
            }
        }
        
        // M goes left -> right and L goes left <- right
        maxL = 0;
        maxM = 0;
        for (int i = M - 1; i < n - L; i++) {
            maxL = maxStack.peekFirst();
            maxM = Math.max(maxM, mSumArr[i]);
            max = Math.max(max, maxL + maxM);
            if (lSumArr[i + L] == maxStack.peekFirst()) {
                maxStack.pollFirst();
            }
        }
        
        return max;
    }
}
