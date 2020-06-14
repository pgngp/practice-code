/* https://leetcode.com/problems/largest-divisible-subset/ */
class LargestDivisibleSubset {
    private Map<Integer, List<Integer>> map;
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // if nums is null or empty
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        } 
        
        // Sort input
        Arrays.sort(nums);
        
        // Initialize map and store the number at the first index
        map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        map.put(nums[0], list);
            
        // Find the max subset among each num
        List<Integer> maxSubset = list;
        for (int i = 1; i < nums.length; i++) {
            List<Integer> newList = getMaxSubset(nums, i);
            if (maxSubset.size() < newList.size()) {
                maxSubset = newList;
            }
        }
        
        return maxSubset;
    }
    
    private List<Integer> getMaxSubset(int[] nums, int index) {
        // If map already contains the subset for the given num
        if (map.containsKey(nums[index])) {
            return map.get(nums[index]);    
        }
        
        // Find the maxsubset using the maxsubsets of all nums so far
        List<Integer> maxSubset = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            List<Integer> list = getMaxSubset(nums, i);
            int maxNum = list.get(list.size() - 1);
            if (nums[index] % maxNum == 0) {
                if (maxSubset.size() < list.size()) {
                    List<Integer> newList = new ArrayList<>(list);
                    maxSubset = newList;
                }
            }
        }
        maxSubset.add(nums[index]);
        map.put(nums[index], maxSubset);
        
        return maxSubset;
    }
}
