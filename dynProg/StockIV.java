/**
 * Best time to buy and sell stock IV (58):
 * Say you have an array for which the ith element is the price of a given stock on day i.Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Ex:
 * Input: [2,4,1], k = 2
 * Output: 2
 * Ex:
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
 */

/*
 * time: O(k * #days)
 * space: O(#days)
 */

public class StockIV {
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices == null || prices.length < 2) {
            return 0;
        }
        
        int pricesLen = prices.length;
        if (k > pricesLen / 2) {
            k = pricesLen / 2;
        }

        int[] t = new int[pricesLen];
        while (k-- >= 1) {
            int maxDiff = -prices[0];
            for (int j = 1; j < pricesLen; ++j) {
                int tmp = Math.max(t[j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, t[j] - prices[j]);
                t[j] = tmp;
            }
        }

        return t[pricesLen - 1];
    }

    private void printMatrix(int[][] m) {
        System.out.println("[");
        for (int row = 0; row < m.length; ++row) {
            System.out.print("  [ ");
            for (int col = 0; col < m[0].length; ++col) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <k> <n> <item1> <item2> ...");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }
        System.out.print("orig:  [ ");
        for (int i = 0; i < n; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        StockIV stock = new StockIV();
        int result = stock.maxProfit(k, nums);
        System.out.println("result: " + result);
    }
}
