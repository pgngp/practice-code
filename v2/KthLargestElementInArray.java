/* https://leetcode.com/problems/kth-largest-element-in-an-array/ */
class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int x = n - k;
        int start = 0, end = n - 1;
        int i = start, j = start;
        while (true) {
            // choose pivot and put it last
            int randNum = start + (int) (Math.random() * (end - start + 1));
            swap(nums, randNum, n - 1);
            
            // go through whole array and partition
            while (j < n - 1) {
                if (nums[j] < nums[n - 1]) {
                    swap(nums, i, j);
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            swap(nums, n - 1, i);
            // System.out.println("rand: " + randNum + ", " + Arrays.toString(nums));
            
            // if this is the xth pos
            if (i == x) {
                break;
            } else if (i < x) {
                i++;
                start = i;
                j = start;
            } else {
                n = end + 1;
                i = start;
                j = start;
            }
        }
        
        return nums[x];
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
