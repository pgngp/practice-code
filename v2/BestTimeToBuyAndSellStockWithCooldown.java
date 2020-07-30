/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/ */
class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, cooldown = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, cooldown - price);
            cooldown = Math.max(cooldown, prevSold);
        }
        
        return Math.max(sold, cooldown);
    }
}
