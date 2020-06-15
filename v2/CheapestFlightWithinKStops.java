/* https://leetcode.com/problems/cheapest-flights-within-k-stops/ */
class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // if flights is empty
        if (flights.length == 0 || flights[0].length == 0) {
            return -1;
        }
        
        // create adj list
        int numFlights = flights.length;
        Map<Integer, Map<Integer, Integer>> srcDstPriceMap = new HashMap<>();
        for (int[] flight : flights) {
            int source = flight[0];
            int dest = flight[1];
            int price = flight[2];
            
            if (!srcDstPriceMap.containsKey(source)) {
                srcDstPriceMap.put(source, new HashMap<>());
            }
            srcDstPriceMap.get(source).put(dest, price);
        }
        
        // create visited set
        Set<Integer> visited = new HashSet<>();
        
        // create priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        pq.add(new int[] {src, 0, -1});
        
        // go through each node in pq
        while (!pq.isEmpty()) {
            // pop node with min dist
            int[] node = pq.poll();
            
            // if source equals destination
            int source = node[0];
            int dist = node[1];
            if (source == dst) {
                return dist;
            }
            
            // if max number of stops has reached
            int stops = node[2];
            if (stops == K) {
                continue;
            }
            
            // add neighbors to pq
            if (!srcDstPriceMap.containsKey(source)) {
                continue;
            }
            Map<Integer, Integer> nestedMap = srcDstPriceMap.get(source);
            for (Map.Entry<Integer, Integer> entry : nestedMap.entrySet()) {
                int dest = entry.getKey();
                int price = entry.getValue();
                pq.offer(new int[] {dest, dist + price, stops + 1});
            }
        }
        
        return -1;
    }
}
