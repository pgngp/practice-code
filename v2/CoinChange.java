/* https://leetcode.com/problems/coin-change/submissions/ */
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, max);
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                
                arr[i] = Math.min(arr[i], arr[i - coins[j]] + 1);
            }
        }
        
        return arr[amount] == amount + 1 ? -1 : arr[amount];
    }
}
