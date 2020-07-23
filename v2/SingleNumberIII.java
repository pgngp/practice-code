/* https://leetcode.com/problems/single-number-iii/ */
class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        // first pass: find overall xor value
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        
        // second pass: find one of the two unique nums
        int bitmask2 = bitmask & (-bitmask);
        int num1 = 0;
        for (int num : nums) {
            if ((bitmask2 & num) != 0) {
                num1 ^= num;
            }
        }
        
        return new int[] {num1, bitmask ^ num1};
    }
}
