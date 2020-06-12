/* https://leetcode.com/problems/next-permutation/ */
class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int small = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                small = i - 1;
                break;
            }
        }
        
        int large = nums.length - 1;
        for (int i = nums.length - 1; i >= small; i--) {
            if (nums[small] < nums[i]) {
                large = i;
                break;
            }
        }
        
        if (small < large) {
            int tmp = nums[small];
            nums[small] = nums[large];
            nums[large] = tmp;
            small++;
        } else {
            small = 0;
        }
        
        int left = small, right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
