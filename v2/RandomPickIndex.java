/* https://leetcode.com/problems/random-pick-index/ */
class RandomPickIndex {
    private Map<Integer, List<Integer>> map;
    private Random random;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }    
        random = new Random();
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
