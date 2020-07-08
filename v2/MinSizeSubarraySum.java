/* https://leetcode.com/problems/minimum-size-subarray-sum/ */
class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0, j = 0, n = nums.length, min = n + 1, sum = 0;
        while (j < n) {
            if (sum < s) {
                sum += nums[j];
                j++;
            } else {
                min = Math.min(min, j - i);
                sum -= nums[i];
                i++;
            }
        }
        
        while (sum >= s) {
            min = Math.min(min, j - i);
            sum -= nums[i];
            i++;
        }
        
        return min == n + 1 ? 0 : min;
    }
}
