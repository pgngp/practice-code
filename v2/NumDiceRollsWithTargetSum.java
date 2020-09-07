/* https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/ */
class NumDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        return dfs(d, f, target, map);
    }
    
    private int dfs(int d, int f, int target, Map<Pair<Integer, Integer>, Integer> map) {
        Pair<Integer, Integer> pair = new Pair<>(d, target);
        if (map.containsKey(pair)) {
            return map.get(pair);
        } else if (d == 0 && target == 0) {
            return 1;
        } else if (d == 0 || target < 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 1; i <= f; i++) {
            count = (count + dfs(d - 1, f, target - i, map)) % 1000000007;
        }
        map.put(pair, count);
        
        return count;
    }
}
