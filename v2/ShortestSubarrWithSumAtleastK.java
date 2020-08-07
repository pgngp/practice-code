/* https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/ */
class ShortestSubarrWithSumAtleastK {
    public int shortestSubarray(int[] A, int K) {
        // create prefix sum arr
        int n = A.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }
        
        // find min length subarr with sum >= K
        Deque<Integer> deque = new ArrayDeque<>();
        int result = n + 1;
        for (int i = 0; i < prefixSum.length; i++) {
            while (!deque.isEmpty() && prefixSum[i] < prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= K) {
                result = Math.min(result, i - deque.pollFirst());
            }
            
            deque.offerLast(i);
        }
        
        return result == n + 1 ? -1 : result;
    }
}
