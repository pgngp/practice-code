/**
 * Product of array except self (103):
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
           result[i] *= product;
           product *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        ProductOfArray p = new ProductOfArray();
        int[] result = p.productExceptSelf(nums);
        System.out.println("result: " + Arrays.toString(result));
    }
}
