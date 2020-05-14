class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // keep counts
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);    
        }
        
        // put top k entries into priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (entry.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(entry);
            }
            // System.out.println("pq: " + pq);
        }
        
        // transfer pq contents to output
        int[] result = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            result[idx++] = pq.poll().getKey();
        }
        
        return result;
    }
}
