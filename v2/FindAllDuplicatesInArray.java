/* https://leetcode.com/problems/find-all-duplicates-in-an-array/ */
class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[idx] = -nums[idx];
            }
        }
        
        return result;
    }
}
