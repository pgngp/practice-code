/**
 * Maximum subarray (143):
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
 */

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            max = max < sum ? sum : max;
            sum = sum < 0 ? 0 : sum;
        }

        return max;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java prog <n> <num1> <num2> ...");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int[] nums = new int[n];
        for (int i = 1; i <= n; ++i) {
            nums[i - 1] = Integer.parseInt(args[i]);
        }

        MaxSubarray ms = new MaxSubarray();
        int sum = ms.maxSubArray(nums);
        System.out.println("max sum: " + sum);
    }
}
