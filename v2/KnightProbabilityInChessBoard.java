/* https://leetcode.com/problems/knight-probability-in-chessboard/ */
class KnightProbabilityInChessBoard {
    public double knightProbability(int N, int K, int r, int c) {       
        // create dirs
        int[][] dirs = new int[][] {{1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}};
        
        // create cache
        double[][][] dp = new double[N][N][K + 1];
        
        // dfs
        return dfs(N, K, r, c, dirs, dp);
    }
    
    private double dfs(int N, int K, int r, int c, int[][] dirs, double[][][] dp) {
        // if out of bound
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0.0;
        } else if (K == 0) {  // if no more steps
            return 1;
        } else if (dp[r][c][K] > 0) {  // if already in cache
            return dp[r][c][K];
        }
        
        // calc prob of using this cell
        double prob = 0.0;
        for (int i = 0; i < dirs.length; i++) {
            prob += 0.125 * dfs(N, K - 1, r + dirs[i][0], c + dirs[i][1], dirs, dp);
        }
        dp[r][c][K] = prob;
        
        return prob;
    }
}
