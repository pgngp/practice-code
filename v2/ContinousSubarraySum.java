/* https://leetcode.com/problems/continuous-subarray-sum/ */
class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if (!map.containsKey(mod)) {
                map.put(mod, i);
            } else if (i - map.get(mod) >= 2) {
                return true;
            }
        }
        
        return false;
    }
}
