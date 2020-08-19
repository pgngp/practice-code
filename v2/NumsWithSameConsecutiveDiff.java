/* https://leetcode.com/problems/numbers-with-same-consecutive-differences/ */
class NumsWithSameConsecutiveDiff {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();
        
        if (N == 1) {
            list.add(0);
        }
        
        for (int i = 1; i <= 9; i++) {
            dfs(N - 1, K, list, i);
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    private void dfs(int N, int K, List<Integer> list, int num) {
        if (N == 0) {
            list.add(num);
            return;
        }
        
        int lastDigit = num % 10;
        if (lastDigit - K >= 0) {
            dfs(N - 1, K, list, num * 10 + lastDigit - K);
        }
        
        if (K > 0 && lastDigit + K <= 9) {
            dfs(N - 1, K, list, num * 10 + lastDigit + K);    
        }
    }
}
