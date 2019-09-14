/**
 * Maximum product subarray (114):
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * http://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/
 */

public class MaxProdSub {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int prod = 1;
        int left = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                for (int j = left; j < i - 1; ++j) {
                   prod /= nums[j];
                   max = Integer.max(max, prod);
                }
                max = Integer.max(max, 0);
                left = i + 1;
                prod = 1;
            } else {
                prod *= nums[i];
                max = Integer.max(max, prod);
            }
        }
        
        for (int j = left; j < nums.length - 1; ++j) {
            prod /= nums[j];
            max = Integer.max(max, prod);
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
        for (int i = 1; i < n + 1; ++i) {
            nums[i - 1] = Integer.parseInt(args[i]);
        }
        MaxProdSub mps = new MaxProdSub();
        int result = mps.maxProduct(nums);
        System.out.println("maxprodsum: " + result);
    }
}
