/* https://leetcode.com/problems/teemo-attacking/ */
class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0, curr = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (curr <= timeSeries[i]) {
                count += duration;
            } else {
                count += duration - (curr - timeSeries[i]);
            }
            curr = timeSeries[i] + duration;
        }
        
        return count;
    }
}
