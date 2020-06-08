/* https://leetcode.com/problems/paint-house-iii/ */
class PaintHousesIII {
    private int[][][] dp;
    private static final int MAX = 1000000000;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // initialize cache
        dp = new int[m][n + 1][target + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        // find min cost
        int min = dfs(houses, cost, target, 0, 0, 0);
        // print(dp);
        
        return min == MAX ? -1 : min;
    }
    
    private int dfs(int[] houses, int[][]cost, int target, int numCommunities, int prevColor, int idx) {
        // if num communities > target
        if (numCommunities > target) {
            return MAX;
        }
        
        // if we've painted all houses
        if (idx >= houses.length) {
            return numCommunities == target ? 0 : MAX;    
        }
        
        // if we already have the min cost cached
        if (dp[idx][prevColor][numCommunities] != -1) {
            return dp[idx][prevColor][numCommunities];
        }
        
        // if current house is already painted
        if (houses[idx] != 0) {
            int min = MAX;
            if (houses[idx] == prevColor) {
                min = dfs(houses, cost, target, numCommunities, houses[idx], idx + 1);
            } else {
                min = dfs(houses, cost, target, numCommunities + 1, houses[idx], idx + 1);
            }
            dp[idx][prevColor][numCommunities] = min;
            
            return min;
        }
        
        // find min cost of painting current house
        int min = MAX;
        for (int i = 0; i < cost[0].length; i++) {
            if (i + 1 != prevColor) {
                min = Math.min(min, cost[idx][i] + dfs(houses, cost, target, numCommunities + 1, i + 1, idx + 1));
            } else {
                min = Math.min(min, cost[idx][i] + dfs(houses, cost, target, numCommunities, i + 1, idx + 1));
            }
        }
        dp[idx][prevColor][numCommunities] = min;
        
        return min;
    }
    
    private void print(int[][][] dp) {
        System.out.println("[");
        for (int i = 0; i < dp.length; i++) {
            System.out.print("  [  ");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print("[");
                for (int k = 0; k < dp[0][0].length; k++) {
                    System.out.print(dp[i][j][k] + ",");
                }
                System.out.print("]");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
