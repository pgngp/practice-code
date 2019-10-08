/**
 * Best time to buy and sell stock III (81):
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * A transaction is a buy & a sell. You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Ex:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Ex:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Ex:
 * Input: [7,6,4,3,1]
 * Output: 0
 * http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

public class StockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[minIdx] > prices[i]) {
                minIdx = i;
                maxIdx = i;
            } else if (prices[maxIdx] < prices[i]) {
                maxIdx = i;
            }
            left[i] = Math.max(left[i - 1], prices[maxIdx] - prices[minIdx]);
        }

        minIdx = prices.length - 1;
        maxIdx = prices.length - 1;
        for (int i = prices.length - 2; i >= 0; --i) {
            if (prices[minIdx] > prices[i]) {
                minIdx = i;
            } else if (prices[maxIdx] < prices[i]) {
                maxIdx = i;
                minIdx = i;
            }
            right[i] = Math.max(right[i + 1], prices[maxIdx] - prices[minIdx]);
        }

        int max = 0;
        for (int i = 0; i < prices.length; ++i) {
            max = Math.max(max, left[i] + right[i]);
        }

        return max;
    }

    private void printMatrix(int[][] m) {
        System.out.println("[");
        for (int row = 0; row < m.length; ++row) {
            System.out.print("[ ");
            for (int col = 0; col < m.length; ++col) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    private void printArr(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <n> <item1> <item2> ...");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.print("orig:  [ ");
        for (int i = 0; i < n; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        StockIII stock = new StockIII();
        int result = stock.maxProfit(nums);
        System.out.println("result: " + result);
    }
}
