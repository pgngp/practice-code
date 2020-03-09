/**
 * Product of array except self (103):
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
 */

/**
 * time: O(n)
 * space: O(n) since we created an output array
 */

public class ArrayProduct {
    public static int[] calculateArrayProduct(int[] arr) {
        int[] result = new int[arr.length];

        result[result.length - 1] = 1;
        for (int i = result.length - 2; i >= 0; --i) {
            result[i] = result[i + 1] * arr[i + 1];
        }

        int tmp = 1;
        for (int i = 1; i < result.length; ++i) {
            tmp *= arr[i - 1];
            result[i] *= tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java <prog> item1 item2 [<item3> ...]");
            System.exit(1);
        }

        int[] arr = new int[args.length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(args[i]);
        }

        System.out.print("Input: ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[] result = calculateArrayProduct(arr);
        System.out.print("Output: ");
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + " ");
        }
        System.out.println("");
    }
}
