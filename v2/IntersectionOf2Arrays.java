/* https://leetcode.com/problems/intersection-of-two-arrays/ */
class IntersectionOf2Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], 0);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], -1) == 0) {
                map.put(nums2[i], 1);
                result.add(nums2[i]);
            }
        }
        
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        
        return arr;
    }
}
