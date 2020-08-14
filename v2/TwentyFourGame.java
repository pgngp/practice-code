/* https://leetcode.com/problems/24-game/ */
class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        double[] arr = new double[] {nums[0], nums[1], nums[2], nums[3]};
        
        return helper(arr);
    }
    
    private boolean helper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24) < 0.001 ? true : false;    
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double[] arr1 = compute(nums, i, j, '+');
                double[] arr2 = compute(nums, i, j, '-');
                double[] arr3 = compute(nums, j, i, '-');
                double[] arr4 = compute(nums, i, j, '*');
                double[] arr5 = compute(nums, i, j, '/');
                double[] arr6 = compute(nums, j, i, '/');
                
                if (helper(arr1) || helper(arr2) || helper(arr3) || helper(arr4) || helper(arr5) || helper(arr6)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private double[] compute(double[] nums, int i, int j, char op) {
        double result = 0;
        if (op == '+') {
            result = nums[i] + nums[j];
        } else if (op == '-') {
            result = nums[i] - nums[j];
        } else if (op == '*') {
            result = nums[i] * nums[j];
        } else {
            result = nums[i] / nums[j];
        }
        
        double[] nums2 = new double[nums.length - 1];
        int x = 0;
        for (int k = 0; k < nums.length; k++) {
            if (k == i) {
                nums2[x++] = result;
            } else if (k != j) {
                nums2[x++] = nums[k];
            }
        }
        
        return nums2;
    }
}
