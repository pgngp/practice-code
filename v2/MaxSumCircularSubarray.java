/* https://leetcode.com/problems/maximum-sum-circular-subarray/ */
class MaxSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, max = Integer.MIN_VALUE, currMax = 0, min = Integer.MAX_VALUE, currMin = 0;
        for (int a : A) {
            currMax = Math.max(currMax + a, a);
            max = Math.max(max, currMax);
            currMin = Math.min(currMin + a, a);
            min = Math.min(min, currMin);
            total += a;
        }
        
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
