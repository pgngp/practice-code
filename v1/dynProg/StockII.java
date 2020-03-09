/**
 * Best time to buy and sell stock II (97):
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Ex:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Ex:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Ex:
 * Input: [7,6,4,3,1]
 * Output: 0
 * http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-ii-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class StockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        int sum = 0;
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[minIdx] > prices[i] || prices[i] < prices[maxIdx]) {
                minIdx = i;
                maxIdx = i;
                sum += max;
                max = 0;
            } else if (i == prices.length - 1) {
                max = Math.max(max, prices[i] - prices[minIdx]);
                sum += max;
            } else {
                max = Math.max(max, prices[i] - prices[minIdx]);
                maxIdx = i;
            }
        }

        return sum;
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
        System.out.print("[ ");
        for (int i = 0; i < n; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        StockII stock = new StockII();
        int result = stock.maxProfit(nums);
        System.out.println("result: " + result);
    }
}
