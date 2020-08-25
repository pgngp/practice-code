/* https://leetcode.com/problems/minimum-cost-for-tickets/ */
class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length + 1];
        for (int i = days.length - 1; i >= 0; i--) {
            // day pass
            int cost0 = costs[0] + cache[i + 1];
            // System.out.println("cost0: " + cost0);
            
            // 7-day pass
            int j = i + 1;
            for (; j < days.length; j++) {
                if (days[j] >= days[i] + 7) {
                    break;
                }
            }
            int cost1 = costs[1] + cache[j];
            // System.out.println("cost1: " + cost1);
            
            // 30-day pass
            j = i + 1;
            for (; j < days.length; j++) {
                if (days[j] >= days[i] + 30) {
                    break;
                }
            }
            int cost2 = costs[2] + cache[j];
            // System.out.println("cost2: " + cost2);
            
            cache[i] = Math.min(cost0, Math.min(cost1, cost2));
        }
        // System.out.println("cache: " + Arrays.toString(cache));
        
        return cache[0];
    }
}
