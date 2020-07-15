/* https://leetcode.com/problems/split-array-largest-sum/ */
class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int numSubArrays = helper(nums, mid);
            if (numSubArrays > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
    
    private int helper(int[] nums, int largestValidSum) {
        int sum = 0, count = 1;
        for (int num : nums) {
            if (sum + num > largestValidSum) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }
        
        return count;
    }
}

/*
func()
    lo = max(all nums)
    hi = sum of all nums
    while lo < hi
        mid = (lo + hi) / 2
        numArrays = split(nums, mid)
        if numArrays > m
            left = mid + 1
        else 
            right = mid
        
        return lo
    
split(nums, largestSum)
    sum = 0
    count = 1
    for each num in nums
        if sum + num > largestSum
            sum = num
            count++
        else
            sum += num
    
    return count
*/
