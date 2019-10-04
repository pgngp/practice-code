/**
 * Best time to buy and sell stock (148):
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class Stock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (prices[minIdx] > prices[i]) {
                minIdx = i;
                continue;
            }

            if (maxIdx <= minIdx || prices[maxIdx] < prices[i]) {
                maxIdx = i;
            }

            if (max < prices[maxIdx] - prices[minIdx]) {
                max = prices[maxIdx] - prices[minIdx];
            }
        }

        return max;
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

        Stock stock = new Stock();
        int result = stock.maxProfit(nums);
        System.out.println("result: " + result);
    }
}
