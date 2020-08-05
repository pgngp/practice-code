/* https://leetcode.com/problems/missing-element-in-sorted-array/ */
class MissingElementInSortedArr {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int missing = getNumMissing(nums, n - 1);
        if (k > getNumMissing(nums, n - 1)) {
            return nums[n - 1] + k - missing;
        }
        
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getNumMissing(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left - 1] + k - getNumMissing(nums, left - 1);
    }
    
    private int getNumMissing(int[] nums, int pos) {
        return nums[pos] - nums[0] - pos;
    }
}
