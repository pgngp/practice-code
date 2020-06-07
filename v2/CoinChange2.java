/* https://leetcode.com/problems/coin-change-2/ */
class CoinChange2 {
   
    public int change(int amount, int[] coins) {     
        int cl = coins.length;
        int[][] dp = new int[cl + 1][amount + 1];
        for (int row = 0; row <= cl; row++) {
            dp[row][0] = 1;
        }
        
        for (int row = 1; row <= cl; row++) {
            for (int col = 1; col <= amount; col++) {
                dp[row][col] = dp[row - 1][col];
                if (col >= coins[row - 1]) {
                    dp[row][col] += dp[row][col - coins[row - 1]];
                }
            }
        }
        // print(dp);
        
        return dp[cl][amount];
    }
    
    private void print(int[][] m) {
        System.out.println("[");
        for (int row = 0; row < m.length; row++) {
            System.out.print("  [  ");
            for (int col = 0; col < m[0].length; col++) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
