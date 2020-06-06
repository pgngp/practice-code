/* https://leetcode.com/problems/minimum-cost-to-connect-sticks/ */
class MinCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        // add sticks to priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++) {
            pq.add(sticks[i]);
        }
        
        // calculate cost
        int total = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            total += sum;
            pq.offer(sum);
        }
        
        return total;
    }
}
